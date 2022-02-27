package com.qiux.tspringboot.network;

import com.qiux.tspringboot.socket.chat.Chat;
import com.qiux.tspringboot.socket.chat.ChatReceive;
import com.qiux.tspringboot.socket.chat.ChatSend;

/**
 * @author qiux
 * @Date 2022/2/27
 * @since
 */
public class TeacherChatTest {
    public static void main(String[] args) {
        Chat receiveInfo = new Chat(9298,9692, "localhost");
        ChatReceive chatReceive = new ChatReceive(receiveInfo);
        Chat sendInfo = new Chat(9798, 9596, "localhost");
        new Thread(chatReceive, "学生").start();
        new Thread(new ChatSend(sendInfo), "老师").start();
    }
}
