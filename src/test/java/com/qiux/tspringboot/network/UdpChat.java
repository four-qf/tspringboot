package com.qiux.tspringboot.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author qiux
 * @Date 2022/2/26
 * @since
 */
public class UdpChat extends Thread {

    private int localPort;

    private int remotePort;

    private String remoteHostName;

    @Override
    public void run() {
        //创建UDP链接
        DatagramSocket datagramSocket = null;
        DatagramPacket packet = null;
        byte[] bytes = null;
        try {
            //创建本地端口
            datagramSocket = new DatagramSocket(localPort);
            //链接远程端口
            datagramSocket.connect(new InetSocketAddress(remoteHostName, remotePort));
            while (true) {
                bytes = new byte[1024];
                packet = new DatagramPacket(bytes, bytes.length);
                datagramSocket.receive(packet);
                byte[] data = packet.getData();
                System.out.println(new String(data,0,packet.getLength()));
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
