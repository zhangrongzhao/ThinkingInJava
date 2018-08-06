package com.thinkingInJava.chapter21.concurrency;

import java.util.concurrent.BlockingQueue;

public class LiftOffRunner implements Runnable{
    private BlockingQueue<LiftOff> rokets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue){
        this.rokets=queue;
    }
    public void add(LiftOff lo){
        try{
            rokets.put(lo);
        }catch(InterruptedException e){
            System.out.println("Interrupted during put()");
        }
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                LiftOff rocket=rokets.take();
                rocket.run();//Use this thread
            }
        }catch(InterruptedException e){
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOff Runner");
    }
}
