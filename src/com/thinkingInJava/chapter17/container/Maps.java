package com.thinkingInJava.chapter17.container;

import com.thinkingInJava.util.CountingMapData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {
    public static void printKeys(Map<Integer,String> map){
        System.out.println("Size="+map.size()+",");
        System.out.println("Keys: ");
        System.out.println(map.keySet());
    }
    public static void test(Map<Integer,String> map){
        System.out.println(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        //Map has 'set' behavior for keys:
        map.putAll(new CountingMapData(25));
        printKeys(map);
        //Producing a Collection of the values:
        System.out.println("Values:");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11):"+map.containsKey(11));
        System.out.println("map.get(11):"+map.get(11));
        System.out.println("map.containsValue(\"F0\"):"+map.containsValue("F0"));
        Integer key=map.keySet().iterator().next();
        System.out.println("First key in map："+key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty():"+map.isEmpty());
        map.putAll(new CountingMapData(25));
        //Operations on the Set change the map:
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty():"+map.isEmpty());
    }
    public static void main(String[] args){
        test(new HashMap<Integer, String>());
        test(new TreeMap<Integer, String>());
        test(new LinkedHashMap<Integer, String>());
        test(new IdentityHashMap<Integer, String>());
        test(new ConcurrentHashMap<Integer, String>());
        test(new WeakHashMap<Integer, String>());
    }
}
