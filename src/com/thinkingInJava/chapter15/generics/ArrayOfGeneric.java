package com.thinkingInJava.chapter15.generics;

public class ArrayOfGeneric {
    static final int SIZE=100;
    static Generic<Integer>[] gia;
    public static void main(String[] args){
        //gia=(Generic<Integer>[])new Object[SIZE];

        //成功创建数组的唯一方式就是创建一个被擦除类型的新数组，然后对其转型
        gia=(Generic<Integer>[])new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0]=new Generic<Integer>();

        //gia[1]=new Object();
        //gia[2]=new Generic<Double>();
    }
}
