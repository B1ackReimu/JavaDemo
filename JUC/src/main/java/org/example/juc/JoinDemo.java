package org.example.juc;

public class JoinDemo {
    public static void main(String[] args) {
        //main启动jvm进程，jvm进程默认的主线程是main
        System.out.println("主线程的名字："+Thread.currentThread().getName());
        //在main线程中，创建一个子线程并启动
        MyThread t1 = new MyThread("子线程1");
        t1.start();
        try {
            t1.join(10); //调用了t1的join方法，main线程就会阻塞，等t1线程执行完毕后，才会继续执行主线程
            //main线程等待，阻塞10ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1线程已经结束");
    }
}

class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println("子线程的名字："+Thread.currentThread().getName()+"-"+i);
        }
    }
}