package org.example.juc;

public class ThreadDemo {

    //main方法运行一个jvm进程和主线程
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(60000);
        for (int i = 1; i <= 10; i++) {
            System.out.println("主线程的名字：" + Thread.currentThread().getName() + i);
            if (i == 5) {
                //创建第一个子线程Thread-0
                new FirstThread().start(); //创建并且启动
                //创建第一个子线程Thread-1
                new FirstThread().start(); //
            }
        }
    }

}

class FirstThread extends Thread {
    @Override
    public void run() {
        super.run();
        // 线程执行体，此线程与实现的任务代码
        for (int i = 1; i <= 10; i++) {
            System.out.println("子线程的名字：" + this.getName() + "-" + i);
        }
    }
}
