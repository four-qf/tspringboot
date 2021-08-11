package com.qiux.tspringboot.socket;

import lombok.SneakyThrows;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author qiuxian
 * @date 2021/8/6
 */
public class SocketServerTest {


    public static void main(String[] args) throws IOException {

        //1.创建socket server 服务
        ServerSocket serverSocket = new ServerSocket(8009);
        System.out.println("第一步：创建端口为8009的端口成功。。。");

        while (true) {

            //2.接收socket client 发送的请求
            Socket socketAccept = serverSocket.accept();

            System.out.println("第二步：端口为8009接收到的客户端连接端--：" + socketAccept.getPort());

            //3.输入流接收client数据
            Thread multiThreadServer = new Thread(new MultiThreadServer(socketAccept));
            multiThreadServer.start();

        }


    }

    static class MultiThreadServer implements Runnable {

        Socket csocket;

        MultiThreadServer(Socket socket) {
            csocket = socket;
        }

        @SneakyThrows
        @Override
        public void run() {
            //3.输入流接收client数据
            InputStream inputStream = csocket.getInputStream();

            //4.打印接收到的数据
            OutputStream out = csocket.getOutputStream();
            Scanner in = new Scanner(inputStream);
            // 阻塞，等待读取客户机数据
            while (in.hasNextLine()) {
                System.out.println("第三步：打印数据--" + Thread.currentThread().getName() + " >> " + in.nextLine());
                // 阻塞，代表服务器业务处理
                Thread.sleep(200);
                // 服务器向客户端回写数据
                out.write(String.valueOf(System.currentTimeMillis()).getBytes());
                // 结尾回写回车+换行
                out.write("\r\n".getBytes());
                // 手动刷新输出流
                out.flush();
            }
            // 关闭连接
            csocket.close();
        }

    }


}

