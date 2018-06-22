package com.thinkingInJava.chapter14.typeinfo;

public class BoundedClassReferences {
    public static void main(String[] args){
        Class<? extends Number> bounded=int.class;//泛型目的：提供编译期类型检查。
        bounded=double.class;
        bounded=Number.class;
        //Or anything else derived from Number
    }
}
