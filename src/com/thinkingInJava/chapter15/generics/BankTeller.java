package com.thinkingInJava.chapter15.generics;

import com.thinkingInJava.util.Generator;

/**
 * Created by rongzhao on 2018/5/16.
 */

class Customer{
    private static long counter=1;
    private final long id=counter++;
    private Customer(){}
    public String toString(){
        return "Customer "+id;
    }

    public static Generator<Customer> generator(){
        return new Generator<Customer>(){
            public Customer next(){ return new Customer();}
        };
    }
}

class Teller{
    private static long counter=1;
    private final long id=counter++;
    private Teller(){}
    public String toString(){return "Teller "+id;}
    //public static Generator<Teller>
}

public class BankTeller {

}
