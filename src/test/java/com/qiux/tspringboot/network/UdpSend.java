package com.qiux.tspringboot.network;

import java.io.IOException;
import java.net.*;

/**
 * @author qiux
 * @Date 2022/2/26
 * @since
 */
public class UdpSend {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(9400);
        byte[] bytes = new String("你好").getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        datagramSocket.connect(InetAddress.getLocalHost(), 9278);
        datagramSocket.send(packet);
        datagramSocket.close();
    }

}
