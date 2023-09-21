package com.anynum.demo.spring;

public class SyncIncrDemo implements Runnable{
    //共享资源(临界资源)
    static int i = 0;
    
    //synchronized关键字修饰实例成员方法
    public synchronized void incr(){
        i++;
    }

    @Override
    public void run() {
        for(int j=0;j<1000;j++){
            incr();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncIncrDemo syncIncrDemo1 = new SyncIncrDemo();
        SyncIncrDemo syncIncrDemo2 = new SyncIncrDemo();
        Thread t1=new Thread(syncIncrDemo1);
        Thread t2=new Thread(syncIncrDemo2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

    public synchronized void incr2(){
        i++;
        new Thread(()->{
            new SyncIncrDemo().incr2();;
        });
        new Thread(()->{
            new SyncIncrDemo().incr2();;
        });
    }

    /**
     * 输出结果:
     * 1991
     */
}