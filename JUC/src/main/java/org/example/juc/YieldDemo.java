package org.example.juc;

public class YieldDemo {
    public static void main(String[] args) {
        new YieldThread("线程1").start();
        new YieldThread("线程2").start();
    }

}

class YieldThread extends Thread {
    public YieldThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(this.getName() + ":" + i + ":" + this.getPriority());
            if (i % 4 == 0) {
                Thread.yield(); //能整除4则让步
            }
        }
    }
}
