package com.thinkingInJava.chapter15.generics;

/**
 * Created by rongzhao on 2018/5/18.
 */
public class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T x){obj=x;}
    public void manipulate(){obj.f();}
}
