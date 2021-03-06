package com.thinkingInJava.chapter17.container;

import java.util.*;

//Using the collections.synchronized methods
public class Synchronization {
    public static void main(String[] args){
        Collection<String> c= Collections.synchronizedCollection(new ArrayList<String>());
        List<String> list=Collections.synchronizedList(new ArrayList<String>());
        Set<String> s=Collections.synchronizedSet(new HashSet<String>());
        Set<String> ss=Collections.synchronizedSortedSet(new TreeSet<String>());
        Map<String,String> m=Collections.synchronizedMap(new HashMap<String,String>());
        Map<String,String> sm=Collections.synchronizedSortedMap(new TreeMap<String, String>());
    }
}
