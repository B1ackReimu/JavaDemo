package org.example.juc;

public class RunnableDemo {

    //main方法运行一个jvm进程和主线程
    public static void main(String[] args) {
        SecondThread secondThread = new SecondThread();
        for (int i = 1; i <= 10; i++) {
            System.out.println("主线程的名字：" + Thread.currentThread().getName() + i);
            if (i == 1) {
                //创建第一个子线程 子线程1
                new Thread(secondThread,"子线程1").start(); //创建并且启动
                //创建第一个子线程 子线程2
                new Thread(secondThread,"子线程2").start();
            }
        }
    }

}

class SecondThread implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("子线程的名字："+Thread.currentThread().getName()+"-"+i);
        }
    }
}
