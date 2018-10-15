package com.thinkingInJava.chapter19.enumerated;

import static com.thinkingInJava.chapter19.enumerated.Spiciness.HOT;
import static com.thinkingInJava.chapter19.enumerated.Spiciness.MEDIUM;
import static com.thinkingInJava.chapter19.enumerated.Spiciness.NOT;

public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree){this.degree=degree;}
    public String toString(){return "Burrito is "+degree;}
    public static void main(String[] args){
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}
