package com.thinkingInJava.chapter04.operators;
//Default equals() does not compare contents.

class Value{
    int i;

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Value)&&(((Value) obj).i==this.i);
    }
}

public class EqualsMethod2 {
    public static void main(String[] args){
        Value v1=new Value();
        Value v2=new Value();
        v1.i=v2.i=100;
        System.out.println(v1.equals(v2));
    }
}
