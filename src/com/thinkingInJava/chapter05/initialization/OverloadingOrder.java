package com.thinkingInJava.chapter05.initialization;
//Overloading based on the order of the arguments
public class OverloadingOrder {
    static void f(String s,int i){

    }

    static void f(int i,String s){

    }

    public static void main(String[] args){
        f("String first",11);
        f(99,"Int first");
    }
}
