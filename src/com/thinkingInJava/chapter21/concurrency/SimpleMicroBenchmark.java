package com.thinkingInJava.chapter21.concurrency;
//The dangers of microBenchmarking

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class Incrementable{
    protected long counter=0;
    public abstract void increment();
}

class SynchronizingTest extends Incrementable{
    public synchronized void increment(){ ++counter; }
}

class LockingTest extends Incrementable{
    private Lock lock = new ReentrantLock();
    public void increment(){
        lock.lock();
        try{
            ++counter;
        }finally {
            lock.unlock();
        }
    }
}

public class SimpleMicroBenchmark {
    static long test(Incrementable incr){
        long start=System.nanoTime();
        for(long i=0;i<10000000L;i++){
            incr.increment();
        }
        return System.nanoTime()-start;
    }
    public static void main(String[] args){
        long syncTime=test(new SynchronizingTest());
        long lockTime=test(new LockingTest());
        System.out.printf("synchronized: %1$10d\n",syncTime);
        System.out.printf("Lock:         %1$10d\n",lockTime);
        System.out.printf("Lock/synchronized=%1$.3f",(double)lockTime/(double)syncTime);
    }
}

//误区：main线程对两种方式做的隔离测试，非多线程环境测试。
