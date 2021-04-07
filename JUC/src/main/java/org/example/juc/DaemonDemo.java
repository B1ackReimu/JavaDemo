package org.example.juc;

public class DaemonDemo {
    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread("后台子线程");
        daemonThread.setDaemon(true); //设置daemonThread为后台子线程
        daemonThread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 5s后，main回归，执行主线程里的任务代码
        for (int i = 1; i < 101; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        ForegroundThread foregroundThread = new ForegroundThread("前台子线程");
        foregroundThread.start();
    }
}

class DaemonThread extends Thread {
    public DaemonThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(1000); //让该线程沉睡1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + ":" + i);
        }
    }
}

class ForegroundThread extends Thread {
    public ForegroundThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(500); //沉睡0.5s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + ":" + i);
        }
    }
}