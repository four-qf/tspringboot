package com.qiux.tspringboot.socket.chat;

import java.io.IOException;
import java.net.*;

/**
 * @author qiux
 * @Date 2022/2/27
 * @since
 */
public class ChatReceive implements Runnable{

    private Chat chat;

    public ChatReceive(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void run() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(chat.getLocalPort());
            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
                try {
                    datagramSocket.connect(new InetSocketAddress(chat.getRemoteHost(), chat.getRemotePort()));
                } catch (SocketException e) {
                    e.printStackTrace();
                }

                try {
                    datagramSocket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] data = packet.getData();
                String msg = new String(data, 0, packet.getLength());
                System.out.println(Thread.currentThread().getName() + ":" + msg);
                if (msg.equalsIgnoreCase("bye")) {
                    break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }


    }
}
