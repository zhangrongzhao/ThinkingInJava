package com.thinkingInJava.util;

import java.util.*;

/**
 * Created by rongzhao on 2018/5/15.
 */
public class New {
    public static <K,V> Map<K,V> map(){
        return new HashMap<K,V>();
    }

    public static <T> List<T> list(){
        return new LinkedList<T>();
    }

    public static <T> Set<T> set(){
        return new HashSet<T>();
    }

    public static <T> Queue<T> queue(){
        return new LinkedList<T>();
    }
}
