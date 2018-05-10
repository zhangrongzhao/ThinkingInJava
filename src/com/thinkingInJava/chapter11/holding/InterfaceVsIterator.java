package com.thinkingInJava.chapter11.holding;

import java.util.*;

/**
 * Created by rongzhao on 2018/5/10.
 */
public class InterfaceVsIterator {
    public static void display(Iterator<Integer> it){
        while(it.hasNext()){
            System.out.print(it.next());
        }
        System.out.println();
    }
    public static void display(Collection<Integer> collection){
        for(Integer n:collection){
            System.out.print(n);
        }
        System.out.println();
    }

    public static void main(String[] args){
        List<Integer> nList= Arrays.asList(1,2,3,4,5,6,7,8,9);
        Set<Integer> nSet=new HashSet<Integer>(nList);
        Map<String,Integer> nMap=new LinkedHashMap<String,Integer>();
        String[] names="Ralph,Eric,Robin,Lacey,Britney,Sam,Spot,Fluffy".split(",");
        for(int i=0;i<names.length;i++){
            nMap.put(names[i],nList.get(i));
        }
        display(nList);
        display(nSet);

        display(nList.iterator());
        display(nSet.iterator());

        System.out.println(nMap);
        System.out.println(nMap.keySet());
        display(nMap.values());
        display(nMap.values().iterator());
    }
}
