package com.ddot.springbootdemo.learntest.currency.thread.wn02;

/**
 * 快递实体类
 *
 */
public class Express {
    public final static String CITY = "ShangHai";
    private int km;
    private String site;

    public Express(){

    }
    public Express(int km,String site){
        this.km = km;
        this.site = site;
    }
    /*
    改变公里数，然后通知处于wait状态并需要处理公里数的线程进行业务处理
     */
    public synchronized void changeKm(){
        this.km = 101;
        notifyAll();    //建议使用notifyall
    }
    /*
    改变地点 然后通知处于wait状态并需要处理地点的线程进行业务处理
     */
    public synchronized void changeSite(){
        this.site = "beijing";
        notifyAll();

    }
    public synchronized void waitKm(){
        while (this.km <= 100){
            try {
                System.out.println("等待前 km");
                wait();
                //表示被通知到 java中 notify只能通知一次 尽量使用notifyall
               System.out.println("check km thread" + Thread.currentThread().getName() + "is be notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the km is " + this.km + "i will change db.");

    }
    public  void waitSite(){
        synchronized (Express.class){
            while (this.site.equals(CITY)){
                try {
                    System.out.println("等待前 site");
                    Express.class.wait();
                    System.out.println("check site thread site" + Thread.currentThread().getName() + "is be notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("the site is " + this.site + "i will change db.");


        }

        }


       /* while (this.site.equals(CITY)){
            try {
                System.out.println("等待前 site");
                wait();
                System.out.println("check site thread" + Thread.currentThread().getName() + "is be notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the site is " + this.site + "i will change db.");
    }*/


}
