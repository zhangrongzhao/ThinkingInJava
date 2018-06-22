package com.thinkingInJava.chapter14.typeinfo;

public class GenericClassReferences {
    public static void main(String[] args){
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intClass=double.class;
        //genericIntClass = double.class;
        //Class<Number> genericNumberClass=int.class;
        Class<?> genericClass=int.class;
    }
}
