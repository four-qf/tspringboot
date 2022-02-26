package com.qiux.tspringboot.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author qiux
 * @Date 2022/2/26
 * @since
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        //创建socket 及开启端口
        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket("localhost", 9999);

            //往其中写数据
            os = socket.getOutputStream();
            String msg = "bye";
            os.write(msg.getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                os.close();
            }
            if (socket != null) {
                socket.close();
            }
        }

    }
}
