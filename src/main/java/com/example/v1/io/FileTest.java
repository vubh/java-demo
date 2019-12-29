package com.example.v1.io;


import java.io.InputStream;

public class FileTest {

    public static void main(String[] args) {
        try {

            InputStream is = FileTest.class.getClassLoader().getResourceAsStream("file.txt");


            //一个字节一个字节读
            int n = 0;
            while ((n = is.read()) != -1) {
                System.out.println(n + "-->" + (char) n + ",");
            }

            //一次读取1M
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
