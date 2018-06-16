package com.thinkingInJava.chapter15.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rongzhao on 2018/6/16.
 */

class Pet{}
class Cat extends Pet{}
class Dog extends Pet{}

public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs){
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args){
        List<Dog> dogs1=new ArrayList<Dog>();
        oldStyleMethod(dogs1);
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(),Dog.class);
        try{
            oldStyleMethod(dogs2);
        }catch(Exception e){
            System.out.println(e);
        }
        List<Pet> pets=Collections.checkedList(new ArrayList<Pet>(),Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
