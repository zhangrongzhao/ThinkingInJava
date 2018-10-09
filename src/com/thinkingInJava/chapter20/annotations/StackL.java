package com.thinkingInJava.chapter20.annotations;

import java.util.LinkedList;

//A stack built on a linkedList
public class StackL<T> {
    private LinkedList<T> list=new LinkedList<T>();
    public void push(T v){list.addFirst(v);}
    public T top(){return list.getFirst();}
    public T pop(){return list.removeFirst();}
}
