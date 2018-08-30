package com.thinkingInJava.chapter21.concurrency;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FastSimulation {
    static final int N_ELEMENTS=100000;
    static final int N_GENES=30;
    static final int N_EVOLVERS=50;
    static final AtomicInteger[][] GRID=new AtomicInteger[N_ELEMENTS][N_GENES];
    static Random rand=new Random(47);
    static class Evolver implements Runnable{
        public void run(){
            while(!Thread.interrupted()){
                //Randomly select an element to work on.
                int element=rand.nextInt(N_ELEMENTS);
                for(int i=0;i<N_GENES;i++){
                    int previous=element-1;
                    if(previous<0){previous = N_ELEMENTS-1;}
                    int next=element+1;
                    if(next>=N_ELEMENTS){next=0;}
                    int oldValue=GRID[element][i].get();
                    //Perform some kind of modeling calculation:
                    int newValue=oldValue+GRID[previous][i].get()+GRID[next][i].get();
                    newValue/=3;
                    //Average the threee values
                    if(!GRID[element][i].compareAndSet(oldValue,newValue)){
                        //Policy here to deal with failure.here we just report it and ingore it;our model will eventually deal with it.
                        System.out.println("Old value changed from "+oldValue);
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws Exception{
        ExecutorService exec=Executors.newCachedThreadPool();
        for(int i=0;i<N_ELEMENTS;i++){
            for(int j=0;i<N_GENES;j++){
                GRID[i][j]=new AtomicInteger(rand.nextInt(1000));
            }
        }
        for(int i=0;i<N_EVOLVERS;i++){
            exec.execute(new Evolver());
        }
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
