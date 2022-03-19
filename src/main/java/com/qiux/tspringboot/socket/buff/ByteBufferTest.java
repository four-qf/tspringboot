package com.qiux.tspringboot.socket.buff;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author qiux
 * @Date 2022/3/19
 * @since
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        String s = "hello";
        byte[] bytes = s.getBytes();
        ByteBuffer bb = ByteBuffer.allocate(1024);
        bb.put(bytes);
        bb.flip();

        FileOutputStream os = null;
        try {
            os = new FileOutputStream("index.txt");
            os.getChannel().write(bb);
            System.out.println(bb.mark());
            System.out.println(bb.position());
            System.out.println(bb.limit());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
