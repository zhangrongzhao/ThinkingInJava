package com.thinkingInJava.chapter21.concurrency;

import java.util.concurrent.TimeUnit;

//General idiom for interrupting a task.
class NeedsCleanup{
    private final int id;
    public NeedsCleanup(int ident){
        this.id=ident;
        System.out.println("NeedsCleanup "+id);
    }
    public void cleanup(){
        System.out.println("Cleaning up "+id);
    }
}

class Blocked3 implements Runnable{
    private volatile double d=0.0;
    public void run(){
        try{
            while(!Thread.interrupted()){
                //point1
                NeedsCleanup n1=new NeedsCleanup(1);
                //Start try-finally immediately after definition
                //of n1,to guarantee proper cleanup of n1
                try{
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    //Point2
                    NeedsCleanup n2=new NeedsCleanup(2);
                    //Guarantee proper cleanup of n2
                    try{
                        System.out.println("Calculating");
                        //A time-comsuming,non-blocking operation:
                        for(int i=1;i<250000;i++){
                            d=d+(Math.PI+Math.E)/d;
                        }
                        System.out.println("Finished time-consuming operation");
                    }finally {
                        n2.cleanup();
                    }
                }finally {
                    n1.cleanup();
                }
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via InterruptedException");
        }
    }
}

public class InterruptingIdiom {
    public static void main(String[] args)throws Exception{
//        if(args.length!=1){
//            System.out.println("usage:java InterruptingIdiom delay-in-mS");
//            System.exit(1);
//        }
        Thread t=new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(5000));
        t.interrupt();
    }
}
