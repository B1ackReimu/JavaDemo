package org.example.juc;

import java.util.concurrent.TimeUnit;

public class SleepDemo2 {
    public static void main(String[] args) {
        Thread thread = new MyThread2();
        thread.start();
        try {
           // MyThread2.sleep(3000); //sleep只让当前线程沉睡
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class MyThread2 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

