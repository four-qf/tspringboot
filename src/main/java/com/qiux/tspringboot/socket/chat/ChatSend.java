package com.qiux.tspringboot.socket.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author qiux
 * @Date 2022/2/27
 * @since
 */
public class ChatSend implements Runnable{

    private Chat chat;

    public ChatSend(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void run() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(chat.getLocalPort());
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String msg = scanner.nextLine();

                byte[] bytes = msg.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
                try {
                    datagramSocket.connect(new InetSocketAddress(chat.getRemoteHost(), chat.getRemotePort()));
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                try {
                    datagramSocket.send(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
