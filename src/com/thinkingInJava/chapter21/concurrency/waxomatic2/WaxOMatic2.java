package com.thinkingInJava.chapter21.concurrency.waxomatic2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Using Lock and Condition objects
class Car{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;
    public void waxed(){
        lock.lock();
        try{
            waxOn = true;//Ready to buff
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void buffed(){
        lock.lock();
        try{
            waxOn = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void waitForWaxing()throws InterruptedException{
        lock.lock();
        try{
            while(this.waxOn==false){
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }
    public void waitForBuffing()throws InterruptedException{
        lock.lock();
        try{
            while(this.waxOn==true){
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }
}

class WaxOn implements Runnable{
    private Car car;
    public WaxOn(Car c){
        this.car=c;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                System.out.println("Wax on!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable{
    private Car car;
    public WaxOff(Car c){this.car=c;}
    public void run(){
       try{
           while(!Thread.interrupted()){
               car.waitForWaxing();
               System.out.println("Wax Off!");
               TimeUnit.MILLISECONDS.sleep(200);
               car.buffed();
           }
       }catch(InterruptedException e){
           System.out.println(e);
       }
       System.out.println("Ending Wax Off task");
    }
}


public class WaxOMatic2 {
    public static void main(String[] args)throws Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
