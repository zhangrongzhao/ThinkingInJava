package com.thinkingInJava.chapter14.typeinfo.pets;

class Individual{
    private static int counter = 0;
    private final int id = counter++;
    private String name = "";

    public Individual(String name){this.name=name;}

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.getClass().getSimpleName();
    }
}

public class Person extends Individual {
    public Person(String name){super(name);}
}
