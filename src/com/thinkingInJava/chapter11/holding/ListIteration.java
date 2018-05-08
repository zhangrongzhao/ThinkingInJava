package com.thinkingInJava.chapter11.holding;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by rongzhao on 2018/5/7.
 */

class Person{}

public class ListIteration {
    public static void main(String[] args){
        ArrayList<Person>  personList = new ArrayList<Person>();
        ListIterator<Person> ite = personList.listIterator();
        while(ite.hasNext()){
           ite.next();
        }

        while(ite.hasPrevious()){
            ite.previous();
        }

        while(ite.hasNext()){
            ite.next();
            //ite.set();
        }
    }
}
