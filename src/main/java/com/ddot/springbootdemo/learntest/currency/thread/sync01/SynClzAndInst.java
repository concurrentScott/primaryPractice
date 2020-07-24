package com.ddot.springbootdemo.learntest.currency.thread.sync01;


import com.ddot.springbootdemo.learntest.currency.tools.SleepTools;

/**
 * 演示对象锁和类锁
 */
public class SynClzAndInst {
    private volatile int age = 100; //不能保证原子性 ，只能保证可见性
    public int getAge(){    //每次取到新的
        return this.age;
    }
    public void setAge(int age){    //volatile强制刷入主内存
        this.age = age;
        //this.age = age + 1;   //不能保证这一操作是原子的
    }
    //使用类锁的线程
    private static class SynClass extends Thread {
        @Override
        public void run() {
            System.out.println("test class is running");
            SynClass();
        }
    }

    //使用对象锁的线程
    private static class InstanceSyn implements Runnable {
        private SynClzAndInst synClzAndInst;

        public InstanceSyn(SynClzAndInst synClzAndInst) {
            this.synClzAndInst = synClzAndInst;
        }

        @Override
        public void run() {
            System.out.println("testinstance is running" + synClzAndInst);
            synClzAndInst.instance();
        }
    }

    //使用对象锁的线程
    private static class Instance2Syn implements Runnable {
        private SynClzAndInst synClzAndInst;

        public Instance2Syn(SynClzAndInst synClzAndInst) {
            this.synClzAndInst = synClzAndInst;
        }
        @Override
        public void run() {
            System.out.println("testinstance2 is running" + synClzAndInst);
            synClzAndInst.instance2();
        }
    }

    private synchronized void instance() {  //对象锁
        SleepTools.second(3);
        System.out.println("synInstance is going " + this.toString());
        SleepTools.second(3);
        System.out.println("synInstance end " + this.toString());

    }

    private synchronized void instance2() {
        SleepTools.second(3);
        System.out.println("synInstance2 is going " + this.toString());
        SleepTools.second(3);
        System.out.println("synInstance2 end " + this.toString());
    }
    private static synchronized void SynClass() {   //类锁 加static修饰
        SleepTools.second(1);
        System.out.println("synClass ");
        SleepTools.second(1);
        System.out.println("synClass " );
    }


    public static void main(String[] args) {
        SynClzAndInst synClzAndInst = new SynClzAndInst();
        SynClzAndInst synClzAndInst1 = new SynClzAndInst();
        Thread t1 = new Thread(new InstanceSyn(synClzAndInst));

        Thread t2 = new Thread(new InstanceSyn(synClzAndInst1));
        t1.start();
        //t2.start();

        SynClass synClass = new SynClass();
        synClass.start();
        SleepTools.second(1);//主线程休眠一秒钟


    }



}
