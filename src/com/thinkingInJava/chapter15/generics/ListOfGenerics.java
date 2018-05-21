package com.thinkingInJava.chapter15.generics;

import java.util.ArrayList;
import java.util.List;

public class ListOfGenerics<T> {
    //使用泛型数组的地方，使用ArrayList
    private List<T> array = new ArrayList<T>();
    public void add(T item){array.add(item);}
    public T get(int index){return array.get(index);}
}
