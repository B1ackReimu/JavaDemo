package org.example.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureDemo {

    public static void main(String[] args) {
        ThirdThread thirdThread = new ThirdThread();
        FutureTask<Integer> futureTask = new FutureTask<>(thirdThread);
        for (int i = 1; i <= 10; i++) {
            System.out.println("主线程的名字：" + Thread.currentThread().getName() + i);
            if (i == 1) {
                //创建第一个子线程 子线程1
                new Thread(futureTask, "子线程1").start(); //创建并且启动

            }
        }
        try {
            System.out.println("子线程返回的值是：" + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ThirdThread implements Callable<Integer> {
    @Override
    public Integer call() {
        int i = 1;
        for (; i <= 10; i++) {
            System.out.println("子线程的名字：" + Thread.currentThread().getName() + "-" + i);
        }
        return i;
    }
}