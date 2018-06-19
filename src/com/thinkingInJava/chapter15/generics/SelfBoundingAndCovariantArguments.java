package com.thinkingInJava.chapter15.generics;

/**
 * Created by rongzhao on 2018/6/16.
 */
interface SelfBoundSetter<T extends SelfBoundSetter<T>>{
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter>{}

public class SelfBoundingAndCovariantArguments {
    void test(Setter s1,Setter s2,SelfBoundSetter sbs){
        s1.set(s2);
        //s1.set(sbs);
    }
}
