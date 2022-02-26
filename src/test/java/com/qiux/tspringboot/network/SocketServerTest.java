package com.qiux.tspringboot.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qiux
 * @Date 2022/2/26
 * @since
 */
public class SocketServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        byte[] bytes = null;
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                accept = serverSocket.accept();
                is = accept.getInputStream();
                baos = new ByteArrayOutputStream(1024);
                bytes = new byte[1024];
                int len;
                while ((len = is.read(bytes)) != -1) {
                    baos.write(bytes, 0, len);
                }
                System.out.println(baos);
                if (baos.toString("utf-8").equalsIgnoreCase("bye")) {
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                is.close();
            }
            if (accept != null) {
                accept.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
