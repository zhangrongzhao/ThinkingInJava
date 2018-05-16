package com.thinkingInJava.chapter15.generics;

import com.thinkingInJava.util.BasicGenerator;
import com.thinkingInJava.util.Generator;

public class BasicGeneratorDemo {
    public static void main(String[] args){
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for(int i=0;i<5;i++){
            System.out.println(gen.next());
        }
    }
}
