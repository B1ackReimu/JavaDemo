package org.example.juc;

public class SleepDemo {
    public static void main(String[] args) {
        new Thread(new MyThread1(),"子线程").start();
        for (int i = 1; i < 4; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

class MyThread1 implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(3000); // 沉睡当前run方法所在的线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < 4; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
