package com.thinkingInJava.chapter21.concurrency;

public class Atomicity {
    int i;
    void f1(){i++;}
    void f2(){i+=3;}
}
