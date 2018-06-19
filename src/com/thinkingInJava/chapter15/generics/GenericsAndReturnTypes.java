package com.thinkingInJava.chapter15.generics;

/**
 * Created by rongzhao on 2018/6/16.
 */
interface GenericGetter<T extends GenericGetter<T>>{
    T get();
}

interface Getter extends GenericGetter<Getter>{}

public class GenericsAndReturnTypes {
    void test(Getter g){
        Getter result=g.get();
        GenericGetter gg=g.get();
    }
}
