package com.qiux.tspringboot.util;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author qiuxian
 * @date 2020/5/23
 */
public class MailUtil {

    public static void main(String[] args) throws MessagingException {


        //1.创建连接(发送方的主机，是否允许发送连接、协议)
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host","smtp.qq.com");
//        properties.setProperty("mail.smtp.port","465");
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.smtp.auth","true");

        final PasswordAuthentication pa = new PasswordAuthentication("552123674@qq.com","uhbjbfaopybebaic");
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return pa;
            }
        };

        Session session = Session.getDefaultInstance(properties, auth);
        //2.创建邮件内容(发送方、接收方、标题、正文、附件)
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom("552123674@qq.com");
//        Address address = new InternetAddress("qiuqiusile@icloud.com");
//        mimeMessage.setSender(address);
        mimeMessage.setRecipients(Message.RecipientType.TO, "qiuxian1028@163.com");
//        mimeMessage.setRecipients(Message.RecipientType.CC, "qiuqiusile@icloud.com");
        mimeMessage.setSubject("hello2");
        mimeMessage.setText("再次晚安");
        //3.发送邮件
        Transport tr = session.getTransport("smtp");
        tr.connect();
        mimeMessage.saveChanges();
        tr.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        tr.close();

    }

}
