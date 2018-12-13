package com.thinkingInJava.chapter05.initialization;

public class MethodInit3 {
    int i=f();
    int j=g(i);//Illegal forward reference
    int f(){return 11;}
    int g(int n){return n*10;}

    public static void main(String[] args){
        MethodInit3 a=new MethodInit3();
    }
}
