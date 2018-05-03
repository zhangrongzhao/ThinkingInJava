package com.thinkingInJava.chapter10.innerclasses;

public class Parcel5 {

    public Destination destination(String s){
        //设计意图：局部内部类。作用域在方法内部。不是Parcel5外部类的一部分
        //所以方法外，是不能访问PDestination
        class PDestination implements Destination{
            private String label;
            private PDestination(String whereTo){
                this.label=whereTo;
            }
            public String readLabel(){return label;}
        }
        return new PDestination(s);
    }

    public static void main(String[] args){
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
}
