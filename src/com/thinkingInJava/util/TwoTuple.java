package com.thinkingInJava.util;

public class TwoTuple<A,B> {
    //final声明只读
    public final A first;
    public final B second;

    public TwoTuple(A a,B b){
        this.first=a;
        this.second=b;
    }

    public String toString(){
        return "(" + first +"," + second + ")";
    }
}
