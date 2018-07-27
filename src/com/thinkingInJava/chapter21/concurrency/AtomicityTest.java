package com.thinkingInJava.chapter21.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private int i=0;
    public int getValue(){return i;}//main线程在读取时，可能读到原子写入的中间不稳定状态。修正方法：getValue()读取时，使用synchronized加入对象锁。写入时，阻止main线程读取直到main线程获取对象锁。
    private synchronized void evenIncrement(){i++;i++;}//原子性写入，但是并不能保证线程安全。
    public void run(){
        while(true){
            evenIncrement();
        }
    }
    public static void main(String[] args){
        ExecutorService exec= Executors.newCachedThreadPool();
        AtomicityTest at=new AtomicityTest();
        exec.execute(at);
        while(true){
            int val=at.getValue();
            if(val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
//结论：单纯依靠原子性，并不能保证共享受限资源的安全。
