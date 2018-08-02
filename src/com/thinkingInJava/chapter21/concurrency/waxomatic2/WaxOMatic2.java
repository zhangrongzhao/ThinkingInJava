package com.thinkingInJava.chapter21.concurrency.waxomatic2;

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

public class WaxOMatic2 {
}
