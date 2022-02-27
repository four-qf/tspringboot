package com.qiux.tspringboot.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author qiux
 * @Date 2022/2/26
 * @since
 */
public class UdpReceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9690);

        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            datagramSocket.connect(InetAddress.getLocalHost(), 9797);
            datagramSocket.receive(packet);
            byte[] data = packet.getData();
            String msg = new String(data, 0, packet.getLength());
            System.out.println(msg);
            if (msg.equalsIgnoreCase("bye")) {
                break;
            }
        }
        datagramSocket.close();

    }
}
