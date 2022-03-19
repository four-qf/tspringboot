package com.qiux.tspringboot.socket.buff;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author qiux
 * @Date 2022/3/18
 * @since
 */
public class FileByteBufferTest {

    public static void main(String[] args) {

        FileOutputStream fout = null;
        FileInputStream fileInputStream = null;
        FileChannel ochannle = null;
        FileChannel ichannle = null;
        try {
            fout = new FileOutputStream("a.txt");
            File file = new File("e.txt");
            file.setReadable(true);
            fileInputStream = new FileInputStream(file);

            ichannle = fileInputStream.getChannel();
            ochannle = fout.getChannel();

            ichannle.transferTo(0, ichannle.size(), ochannle);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ichannle.close();
                ochannle.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fout != null) {
                try {
                    fileInputStream.close();
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
