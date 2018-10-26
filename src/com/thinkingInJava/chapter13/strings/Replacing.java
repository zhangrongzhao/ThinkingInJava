package com.thinkingInJava.chapter13.strings;

public class Replacing {
    static String s=Splitting.knights;
    public static void main(String[] args){
        //Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest...with... a herring!";
        System.out.println(s.replaceFirst("f\\w+","located"));
        System.out.println(s.replaceAll("shrubbery|tree|herring","banana"));
    }
}
