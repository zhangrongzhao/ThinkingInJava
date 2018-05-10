package com.thinkingInJava.chapter11.holding;

import java.util.Map;

/**
 * Created by rongzhao on 2018/5/10.
 */
public class EnvironmentVariables {
    public static void main(String[] args){
        for(Map.Entry entry:System.getenv().entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
