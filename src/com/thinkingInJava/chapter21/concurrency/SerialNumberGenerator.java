package com.thinkingInJava.chapter21.concurrency;

public class SerialNumberGenerator {
    private static volatile int serialNumber=0;
    public static int nextSerialNumber(){
        return serialNumber++;//Not thread-safe
    }
}
//单纯依靠volatile的可视性，也不能保证线程共享受限资源的安全。
//可以从java线程的工作内存模型角度解释。volatile的可视性：主存<==>Load &&save <==>线程工作内存。
//解决方法：nextSerialNumber()方法加上Synchronized关键字。使用对象锁同步共享受限资源的操作。
