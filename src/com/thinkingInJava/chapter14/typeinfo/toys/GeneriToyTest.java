package com.thinkingInJava.chapter14.typeinfo.toys;

public class GeneriToyTest {
    public static void main(String[] args)throws Exception{
        Class<FancyToy> ftClass = FancyToy.class;
        //Produces exact type
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        //Class<Toy> up2=ftClass.getSuperclass();
        //Only produces Object
        Object obj = up.newInstance();
    }
}
