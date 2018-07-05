package com.thinkingInJava.chapter17.containter;

import com.thinkingInJava.util.CollectionData;
import com.thinkingInJava.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

class Government implements Generator<String> {
    String[] fundation=("Strange women lying in ponds distributing swords is no basis for a system of government").split(" ");
    private int index;
    public String next(){
        return fundation[index++];
    }
}


public class CollectionDataTest {
    public static void main(String[] args){
        Set<String>  set = new LinkedHashSet<String>(new CollectionData<String>(new Government(),15));
        //Using the convenience method
        set.addAll(CollectionData.list(new Government(),15));
        System.out.println(set);
    }
}
