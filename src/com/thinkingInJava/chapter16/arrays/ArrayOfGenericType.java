package com.thinkingInJava.chapter16.arrays;

import com.thinkingInJava.chapter15.generics.ArrayOfGeneric;

//Arrays o generic types won't compile
public class ArrayOfGenericType<T> {
    T[] array;//OK
    public ArrayOfGenericType(int size){
        //array=new T[size];
        array=(T[])new Object[size];//
    }
    //Illegal:
    public <U> U[] makeArray(){return (U[])new Object[10];}
}
