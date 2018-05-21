package com.thinkingInJava.chapter15.generics;

public class GenericArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz){
        array=(T[])new Object[sz];
    }

    public void put(int index,T item){
        array[index]=item;
    }
}
