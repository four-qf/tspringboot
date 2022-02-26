package com.qiux.tspringboot.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author qiux
 * @Date 2022/2/26
 * @since
 */
public class UdpRecive {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9278);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        datagramSocket.connect(InetAddress.getLocalHost(), 9400);
        datagramSocket.receive(packet);

        byte[] data = packet.getData();
        System.out.println(new String(data,0,packet.getLength()));
        datagramSocket.close();

    }
}
