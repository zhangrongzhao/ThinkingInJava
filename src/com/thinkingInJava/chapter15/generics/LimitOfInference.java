package com.thinkingInJava.chapter15.generics;

import com.thinkingInJava.util.New;

import java.util.Map;

/**
 * Created by rongzhao on 2018/5/15.
 */
public class LimitOfInference {
    static void f(Map<String,Integer> map){}
    public static void main(String[] args){
        //显示类型声明
        f(New.<String,Integer>map());
    }
}
