package com.thinkingInJava.chapter15.generics;

public class ReturnGenericType<T extends HasF> {
    private T obj;
    public ReturnGenericType(T x){this.obj=x;}
    public T get(){return obj;}
}
