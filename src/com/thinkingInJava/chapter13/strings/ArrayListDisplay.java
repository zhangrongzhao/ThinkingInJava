package com.thinkingInJava.chapter13.strings;

import com.thinkingInJava.chapter15.coffee.Coffee;
import com.thinkingInJava.chapter15.coffee.CoffeeGenerator;

import java.util.ArrayList;

public class ArrayListDisplay {
    public static void main(String[] args){
        ArrayList<Coffee> coffees=new ArrayList<Coffee>();
        for(Coffee c:new CoffeeGenerator(10)){
            coffees.add(c);
        }
        System.out.println(coffees);
    }
}
