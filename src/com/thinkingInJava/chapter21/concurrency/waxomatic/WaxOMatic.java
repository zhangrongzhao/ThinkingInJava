package com.thinkingInJava.chapter21.concurrency.waxomatic;
//Basic task cooperation

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car{
    private boolean waxOn=false;
    public synchronized void waxed(){//上蜡
        waxOn=true;//Ready to buff
        notifyAll();
    }
    public synchronized void buffed(){//抛光
        waxOn=false;//Ready for another coat of wax
        notifyAll();
    }
    public synchronized void waitForWaxing()throws InterruptedException{
        while(waxOn==false){
            wait();//线程挂起，锁被释放
        }
    }
    public synchronized void waitForBuffing()throws InterruptedException{
        while(waxOn==true){
            wait();
        }
    }
}

class WaxOn implements Runnable{
    public Car car;
    public WaxOn(Car c){this.car=c;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                System.out.println("Wax on! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();//上蜡
                car.waitForBuffing();//等待抛光
            }
        }catch(InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable{//抛光任务
    private Car car;
    public WaxOff(Car c){this.car=c;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                car.waitForWaxing();//等待上蜡
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();//抛光
            }
        }catch(InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args)throws Exception{
        Car car = new Car();
        ExecutorService exec= Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);//Run for a while...
        exec.shutdownNow();
    }
}
