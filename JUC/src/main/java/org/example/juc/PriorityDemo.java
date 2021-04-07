package org.example.juc;

public class PriorityDemo {
    public static void main(String[] args) {
        System.out.println("main线程默认优先级别："+Thread.currentThread().getPriority());
        PriorityThread t1 = new PriorityThread("低级");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        PriorityThread t2 = new PriorityThread("高级");
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
    }
}

class PriorityThread extends Thread{
    public PriorityThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(this.getName()+":"+i+":"+this.getPriority());
        }
    }
}