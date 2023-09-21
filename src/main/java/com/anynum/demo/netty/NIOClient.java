package com.anynum.demo.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author guopeng.Zgp 2022.05.27
 */
public class NIOClient {
    public static void main(String[] args) {

        startClient();

    }

    private static void startClient() {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            ThreadLocalRandom current = ThreadLocalRandom.current();

            InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 7001);

            while (!socketChannel.connect(socketAddress)) {
                System.out.println("连接异常");
            }
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                String hello = "hello " + current.nextInt(100000);
                buffer.put(hello.getBytes());

                socketChannel.write(buffer);
                System.out.println("send hello: " + hello);
                TimeUnit.SECONDS.sleep(5);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
