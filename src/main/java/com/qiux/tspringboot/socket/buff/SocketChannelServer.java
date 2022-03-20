package com.qiux.tspringboot.socket.buff;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author qiux
 * @Date 2022/3/19
 * @since
 */
public class SocketChannelServer {

    public static void main(String[] args) {

        ServerSocketChannel serverChannel = null;
        try {

            serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.bind(new InetSocketAddress("localhost", 9999));
            Selector selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (selector.select() > 0) {

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {

                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        SocketChannel accept = serverChannel.accept();
                        accept.configureBlocking(false);
                        accept.register(selector, SelectionKey.OP_READ);
                    }

                    if (key.isReadable()) {

                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        SocketChannel channel = (SocketChannel) key.channel();
                        int len = 0;
                        while ( (len = channel.read(byteBuffer) ) > 0) {
                            byteBuffer.flip();
                            String msg = new String(byteBuffer.array(),0, len);
                            System.out.println("------------msg:" + msg);
                            byteBuffer.clear();
                        }


                    }
                    iterator.remove();

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverChannel != null) {
                try {
                    serverChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
