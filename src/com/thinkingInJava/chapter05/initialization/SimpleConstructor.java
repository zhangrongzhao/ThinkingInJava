package com.thinkingInJava.chapter05.initialization;
//Demonstration of a simple constructor.

class Rock{
    Rock(){//This is the constructor
        System.out.println("Rock ");
    }
}

public class SimpleConstructor {
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            new Rock();
        }
    }
}
