package com.thinkingInJava.chapter15.generics;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args){
        List<? extends Fruit> flist= Arrays.asList(new Apple());
        //flist.add(new Object());
        Apple a=(Apple)flist.get(0);
        flist.contains(new Apple());//Argument is Object,不涉及通配符
        flist.indexOf(new Apple());//Argument is Object，不涉及通配符
    }

}
