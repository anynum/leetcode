package com.alibaba.coin.demo;

import com.alibaba.fastjson.JSON;

import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author guopeng.Zgp 2022.08.09
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(){
                @Override
                public void run() {
                    String s = UUID.randomUUID().toString();
                    map.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
                    System.out.println(s);
                    countDownLatch.countDown();
                }
            }.start();

        }
        System.out.println("----coundownlatch--------");
        countDownLatch.await();

        System.out.println("JSON.toJSONString(map) = " + JSON.toJSONString(map));

    }



}
