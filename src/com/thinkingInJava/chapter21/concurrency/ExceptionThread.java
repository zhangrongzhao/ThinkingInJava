package com.thinkingInJava.chapter21.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//ThrwosException
public class ExceptionThread implements Runnable {
    public void run(){
        throw new RuntimeException();
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
