package com.alibaba.coin.demo.io;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * comment:
 * author: guopeng
 * since: 2021.09.23
 */
public class NIOTest {
    public static void main(String[] args) {
        try {
            reader();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void reader() throws Exception {

        RandomAccessFile reader = new RandomAccessFile("src/main/resources/reader.txt", "rw");
        RandomAccessFile writer = new RandomAccessFile("src/main/resources/writer.txt", "rw");
        FileChannel channel = reader.getChannel();
        FileChannel writerChannel = writer.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);
        while (read != -1) {
             buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            writerChannel.write(buffer);
            buffer.clear();
            read = channel.read(buffer);
        }

        channel.close();
        writerChannel.close();
    }

}


