package com.thinkingInJava.chapter17.container;

public abstract class Test<C> {
    String name;
    public Test(String name){this.name = name;}
    //override this method for different tests
    //returns actual number of repetitions of test
    abstract int test(C container,TestParam tp);
}
