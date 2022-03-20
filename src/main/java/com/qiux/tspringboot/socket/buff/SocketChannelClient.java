package com.qiux.tspringboot.socket.buff;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author qiux
 * @Date 2022/3/19
 * @since
 */
public class SocketChannelClient {

    public static void main(String[] args) {

        SocketChannel socketChannel = null;
        try {

            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            boolean flag = socketChannel.connect(new InetSocketAddress("localhost", 9999));
            System.out.println(flag);
            if (!flag) {
                 while (!socketChannel.finishConnect()) {
                     System.out.println("---------继续链接");
                 }
            }
//            byte[] bytes = "你好".getBytes();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.next();
                byte[] bytes = msg.getBytes();
                ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
                byteBuffer.put(bytes);
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
