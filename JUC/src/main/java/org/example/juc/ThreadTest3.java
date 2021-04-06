package org.example.juc;

public class ThreadTest3 {

    //main方法运行一个jvm进程和主线程
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            System.out.println("主线程的名字：" + Thread.currentThread().getName() + i);
            if (i == 1) {
                new Thread(() -> {
                    for (int j = 1; j <= 10; j++) {
                        System.out.println("子线程的名字："+Thread.currentThread().getName()+"-"+j);
                    }
                },"子线程1").start();
                new Thread(() -> {
                    for (int j = 1; j <= 10; j++) {
                        System.out.println("子线程的名字："+Thread.currentThread().getName()+"-"+j);
                    }
                },"子线程2").start();
            }
        }
    }

}
