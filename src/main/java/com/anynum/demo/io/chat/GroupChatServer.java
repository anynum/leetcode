package com.anynum.demo.io.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author guopeng.Zgp 2022.06.20
 */
public class GroupChatServer {
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int port = 6667;

    public GroupChatServer() {
        try {
            /*得到选择器*/
            selector = Selector.open();
            /*ServerSocketChannel*/
            listenChannel = ServerSocketChannel.open();
            /*绑定端口*/
            listenChannel.bind(new InetSocketAddress(port));
            /*设置非阻塞*/
            listenChannel.configureBlocking(false);
            /*将listenChannel注册到selector*/
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void listen() {
        try {
            while (true) {
                int count = selector.select();
                if (count > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isAcceptable()) {
                            SocketChannel sc = listenChannel.accept();
                            sc.register(selector, SelectionKey.OP_READ);
                            System.out.println(sc.getRemoteAddress() + " 上线了！");
                        }

                        if (key.isReadable()) { // 处理读事件
                            /*TODO*/
                        }
                        iterator.remove();
                    }
                } else {
                    System.out.println("等待消息。。。");
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readData(SelectionKey key) {
        SocketChannel channel = null;
        try {
            /*取得关联的channel*/
            channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            if (count > 0) {
                String msg = new String(buffer.array());
                System.out.println("msg = " + msg);

                /*向其他客户端转发消息*/

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void send(String msg, SocketChannel self) throws IOException {
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != self) {
                SocketChannel dest = (SocketChannel) targetChannel;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                dest.write(buffer);
            }
        }
    }
}
