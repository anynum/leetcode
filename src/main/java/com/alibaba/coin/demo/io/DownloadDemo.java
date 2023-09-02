package com.alibaba.coin.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * @author guopeng.Zgp 2022.05.23
 */
public class DownloadDemo {
    public static void main(String[] args) throws Exception {
        BufferedReader in = null;
        BufferedWriter writer = null;
        try {
            URL oracle = new URL("https://arthas.aliyun.com/arthas-boot.jar");
            in = new BufferedReader(new InputStreamReader(oracle.openStream()));

            char[] inputLine = new char[1024];
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/guopeng/Desktop/arthas-boot.jar")));
//            int read = in.read(inputLine);
            while (in.read(inputLine) != -1) {
                writer.write(inputLine);
            }
        } finally {
            in.close();
            writer.close();
        }

    }

}
