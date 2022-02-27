package com.qiux.tspringboot.network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author qiux
 * @Date 2022/2/26
 * @since
 */
public class UdpSend {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(9797);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.nextLine();
            System.out.println(msg);

            byte[] bytes = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            datagramSocket.connect(new InetSocketAddress("localhost", 9690));
//            datagramSocket.connect(InetAddress.getLocalHost(), 9690);
            datagramSocket.send(packet);
            if (msg.equalsIgnoreCase("bye")) {
                break;
            }
        }
        datagramSocket.close();
    }

}
