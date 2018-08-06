package com.thinkingInJava.chapter21.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

//Performs some portion of a task:
class TaskPortion implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand=new Random(47);
    private final CountDownLatch latch;
    TaskPortion(CountDownLatch latch){
        this.latch=latch;
    }
    public void run(){
       try{
           doWork();
           latch.countDown();
       }catch(InterruptedException ex){
           //Acceptable way to exit
       }
    }
    public void doWork()throws InterruptedException{
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this +" Completed");
    }
    public String toString(){
        return String.format("%1$-3d",id);
    }
}

//Waits on the CountDownLatch:
class WaitingTask implements Runnable{
    private static int counter=0;
    private final int id=counter++;
    private final CountDownLatch latch;
    WaitingTask(CountDownLatch latch){
        this.latch=latch;
    }
    public void run(){
        try{
            latch.wait();
            System.out.println("Latch barrier for " + this);
        }catch (InterruptedException ex){
            System.out.println(this+" interrupted");
        }
    }
    public String toString(){
        return String.format("WaitingTask %1$-3d",id);
    }
}

public class CountDownLatchDemo {
    static final int SIZE=100;
    public static void  main(String[] args)throws Exception{

    }
}
