package com.thinkingInJava.chapter05.initialization;
//Calling constructors with "this"
public class Flower {
    int petalCount=0;
    String s="initial value";
    Flower(int petals){
        petalCount=petals;
        System.out.println("Constructor w/ int arg only,petalCount="+petalCount);
    }

    Flower(String ss){
        System.out.println("Construtor w/ String arg only,s="+ss);
        s=ss;
    }

    Flower(String s,int petals){
        this(petals);
        //!this(s);  //can not call two.
        this.s=s;//Another use of this
        System.out.println("String & int args");
    }

    Flower(){
        this("hi",47);
        System.out.println("default constructor (on args)");
    }

    void printPetalCount(){
        //this(11);//Not inside non-constructor!
        System.out.println("petalCount="+petalCount+"s="+s);
    }

    public static void main(String[] args){
        Flower x=new Flower();
        x.printPetalCount();
    }
}
