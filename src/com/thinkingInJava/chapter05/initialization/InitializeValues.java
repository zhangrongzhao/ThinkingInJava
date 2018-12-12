package com.thinkingInJava.chapter05.initialization;
//Show default initial values.
public class InitializeValues {
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitializeValues reference;
    void printInitialValues(){
        System.out.println("Data type     Initial value");
        System.out.println("boolean       "+t);
        System.out.println("char          ["+c+"]");
        System.out.println("byte          "+b);
        System.out.println("short         "+s);
        System.out.println("int           "+i);
        System.out.println("float         "+f);
        System.out.println("double        "+d);
        System.out.println("reference     "+reference);
    }
    public static void main(String[] args){
        InitializeValues iv=new InitializeValues();
        iv.printInitialValues();
        /*You could also say:*/
        new InitializeValues().printInitialValues();
    }
}
