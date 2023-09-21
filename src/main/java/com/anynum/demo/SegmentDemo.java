package com.anynum.demo;

import com.anynum.demo.util.MapUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author guopeng.Zgp 2022.07.06
 */
public class SegmentDemo {
    public static void main(String[] args) {
        String sentence = "表示在脚本中所用到的那些";

//        segment(sentence);

//        try {
//            SocketChannel socketChannel = null;
//            socketChannel = socketChannel.open(new InetSocketAddress("127.0.0.1",8799));
//            System.out.println("socketChannel = " + socketChannel);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        HashSet<Integer> hashSet = new HashSet<>();
//        hashSet.add(80);
//        hashSet.add(100);
//        hashSet.add(90);
//        System.out.println("hashSet.toString() = " + hashSet.toString());
//        Set<Integer> newSet = hashSet.stream().sorted((o1, o2) -> o1 - o2).collect(Collectors.toSet());
//        System.out.println("newSet.toString() = " + newSet.toString());

        MapUtils mapUtils = null;
        mapUtils.split();

    }

    public static void segment(String sentence){
        int slen = sentence.length();
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i <= slen; i++) {
            for (int j = 0; j <= slen - i; j++) {
                String word = sentence.substring(j,j+i);
                // 1.正常sentence截词levelDB查询结果
                set.add(word);
            }
        }

        Set<String> collect = set.stream().sorted().collect(Collectors.toSet());
        System.out.println("set = " + set.size());




        try {
            SocketChannel socketChannel = null;
            socketChannel = socketChannel.open(new InetSocketAddress("127.0.0.1",8799));
        } catch (IOException e) {
            // ignore it
        }


        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(80);
        hashSet.add(100);
        hashSet.add(90);
        System.out.println("hashSet.toString() = " + hashSet.toString());
        Set<Integer> newSet = hashSet.stream().sorted((o1, o2) -> o1 - o2).collect(Collectors.toSet());
        System.out.println("newSet.toString() = " + newSet.toString());

//        SocketChannel.open()



    }
}
