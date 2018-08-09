package com.thinkingInJava.chapter21.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//Testing the Pool class
//A task to check a resource out of a pool
class CheckoutTask<T> implements Runnable{
    private static int counter=1;
    private final int id=counter++;
    private Pool<T> pool;
    public CheckoutTask(Pool<T> pool){
        this.pool=pool;
    }
    public void run(){
        try{
            T item=pool.checkOut();
            System.out.println(this + " checked out " + item);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this+" checking in  " + item);
            pool.checkIn(item);
        }catch(InterruptedException e){
            //Acceptable way to terminate
        }
    }
    public String toString(){
        return "CheckoutTask "+id+" ";
    }
}

public class SemaphoreDemo {
    final static int SIZE=25;
    public static void main(String[] args)throws Exception {
        final Pool<Fat> pool=new Pool<Fat>(Fat.class,SIZE);
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int i=0;i<SIZE;i++){
            exec.execute(new CheckoutTask<Fat>(pool));
        }
        System.out.println("All CheckoutTasks created");
        List<Fat> list=new ArrayList<Fat>();
        for(int i=0;i<SIZE;i++){
            Fat f=pool.checkOut();
            System.out.println(i+": main() thread checkout out ");
            f.operation();
            list.add(f);
        }
        Future<?> blocked=exec.submit(new Runnable(){
            public void run(){
                try{
                    //Semaphore prevents additional checkout
                    //So call is blocked:
                    pool.checkOut();
                }catch(InterruptedException e){
                    System.out.println("checkOut() interrupted");
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);//Break out of blocked call
        System.out.println("Checking in objects in "+list);
        for(Fat f:list){
            pool.checkIn(f);
        }
        for(Fat f:list){
            pool.checkIn(f);//Second checkIn ignored
        }
        exec.shutdown();
    }
}
