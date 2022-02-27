package com.qiux.tspringboot.network;

import com.qiux.tspringboot.socket.chat.Chat;
import com.qiux.tspringboot.socket.chat.ChatReceive;
import com.qiux.tspringboot.socket.chat.ChatSend;

import java.io.IOException;

/**
 * @author qiux
 * @Date 2022/2/27
 * @since
 */
public class StudentChatTest {

    public static void main(String[] args) throws IOException {
        Chat receiveInfo = new Chat(9596,9798, "localhost");
        ChatReceive chatReceive = new ChatReceive(receiveInfo);
        Chat sendInfo = new Chat(9692, 9298, "localhost");

        new Thread(chatReceive, "老师").start();
        new Thread(new ChatSend(sendInfo), "学生").start();

    }

}
