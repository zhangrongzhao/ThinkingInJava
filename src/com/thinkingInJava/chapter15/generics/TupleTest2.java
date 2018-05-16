package com.thinkingInJava.chapter15.generics;

import com.thinkingInJava.util.ThreeTuple;
import com.thinkingInJava.util.TwoTuple;

import static com.thinkingInJava.util.Tuple.tuple;

public class TupleTest2 {
    static TwoTuple<String,Integer> f(){
        return tuple("hi",47);
    }

    static TwoTuple f2(){ return tuple("hi",47); }

    static ThreeTuple<String,String,Integer> g(){
        return tuple("hello","world",47);
    }

    static ThreeTuple g2(){return tuple("hello","world",47);}
}
