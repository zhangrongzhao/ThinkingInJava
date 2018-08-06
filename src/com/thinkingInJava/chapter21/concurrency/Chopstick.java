package com.thinkingInJava.chapter21.concurrency;

public class Chopstick {//筷子
    private boolean taken=false;
    public synchronized void take()throws InterruptedException{
        while(taken){
            wait();
        }
        taken=true;
    }
    public synchronized void drop(){
        taken=false;
        notifyAll();
    }
}
