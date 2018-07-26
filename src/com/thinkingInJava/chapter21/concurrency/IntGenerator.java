package com.thinkingInJava.chapter21.concurrency;

public abstract class IntGenerator {
    private volatile boolean canceled=false;
    public abstract int next();
    //Allow this to be canceled.
    public void cancel(){this.canceled=true;}
    public boolean isCanceled(){return canceled;}
}
