package org.example.juc;

import java.util.concurrent.TimeUnit;

public class SynchronizedDemo {
    public static void main(String[] args) {
        SynchronizedThread st = new SynchronizedThread();
        //创建并开启4个线程来卖100张票
        new Thread(st,"线程1").start();
        new Thread(st,"线程2").start();
        new Thread(st,"线程3").start();
        new Thread(st,"线程4").start();
    }
}

class SynchronizedThread implements Runnable {
    //定义在这里的数据是线程共享的
    private int ticketNumber = 100; //总数100张
    private final Object object = new Object();
    @Override
    public void run() {
        //子线程的任务是卖票
        while (true) {
            synchronized (object){
                if (ticketNumber > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10); //放大线程安全问题
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程：" + Thread.currentThread().getName() + "卖掉第" + ticketNumber + "号票");
                    ticketNumber--;
                } else {
                    break;
                }
            }
        }
    }
}
