package com.thinkingInJava.chapter21.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

//Atomic classes are occasionally useful in regular code.
//RunByHand
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger();
    public int next(){
        return currentEvenValue.addAndGet(2);
    }
    public static void main(String[] args){
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
