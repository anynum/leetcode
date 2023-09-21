package com.anynum.demo.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author guopeng.Zgp 2022.05.27
 */
public class NIOServer {
    public static void main(String[] args) {

        try {
            startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startServer() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(7001));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        // 注册到selector， 设置关心的事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() != 0){

            if (selector.select(5000) == 0){
                System.out.println("wait 5s, no connection");
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            if (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()){
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("receive new connection");
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if (selectionKey.isReadable()){
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    ByteBuffer buffer  = (ByteBuffer)selectionKey.attachment();

                    int read = channel.read(buffer);
                    System.out.println("read from client: " + new String(buffer.array()));
                }
                iterator.remove();
            }
        }


    }

}
