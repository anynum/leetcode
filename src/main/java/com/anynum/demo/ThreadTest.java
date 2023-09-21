package com.anynum.demo;

import com.anynum.demo.util.ThreadLocalUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author guopeng.Zgp 2022.05.16
 */
//@Data
//@Slf4j
public class ThreadTest {
    private ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("msg-manager-%d").build();

    private ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 10, 0,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), namedThreadFactory);


    public static void main(String[] args) throws InterruptedException {
        ThreadTest threadTest = new ThreadTest();
        threadTest.testThread();

        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("string");
        InheritableThreadLocal<Object> local1 = new InheritableThreadLocal<>();

        local.get();

        HashMap<String, String> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();


    }

    public void testThread(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int num;
        int times = 2;
        while (true){
            num = random.nextInt(10000);
            // 线程池创建时，活跃线程数为0，有请求进来时，只要活跃线程数小于核心线程数就会创建新的线程。
            if (--times == 0){
               break;
            }
            System.out.println("times = " + num);
            executorService.submit(new MsgRunner(Integer.toString(num)));
        }
    }

    private void consumeMetaqMsg(String msg) {
        String value = ThreadLocalUtil.get(Thread.currentThread().getName());

//        log.info("[{}] -g-> [{}]",Thread.currentThread().getName(), value);
//        System.out.printf("[%s] -g-> [%s]%n",Thread.currentThread().getName(), value);
//        System.out.println("msg = " + msg);


    }

    private class MsgRunner implements Runnable{
        Random random = new Random();

        private String msg;

        public MsgRunner(String data){
            this.msg = data;
        }
        @Override
        public void run() {
            while (true){
                ThreadLocalUtil.set(Thread.currentThread().getName(), msg );
//                System.out.printf("[%s] -s-> [%s]%n",Thread.currentThread().getName(), msg);
                consumeMetaqMsg(msg);
                String remove = ThreadLocalUtil.remove(Thread.currentThread().getName());

            }

        }
    }


}
