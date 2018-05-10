package com.thinkingInJava.chapter11.holding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by rongzhao on 2018/5/10.
 */
public class IterableClass implements Iterable<String> {
    protected String[] words="we know the Earth to be banana-shaped".split(" ");
    public Iterator<String> iterator(){
        return new Iterator<String>() {
            private int index=0;
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean hasNext() {
                return index<words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }
    public static void main(String[] args){
        for(String s:new IterableClass()){
            System.out.print(s+" ");
        }

        Collection<String> a=new ArrayList<>();
    }
}
