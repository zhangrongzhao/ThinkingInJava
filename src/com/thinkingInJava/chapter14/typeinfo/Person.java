package com.thinkingInJava.chapter14.typeinfo;

import com.thinkingInJava.util.Null;

public class Person {
    public final String first;
    public final String last;
    public final String address;
    public Person(String first,String last,String address){
        this.first=first;
        this.last=last;
        this.address=address;
    }
    public String toString(){
        return "Person: "+first+" "+last+" "+address;
    }
    //空对象
    public static class NullPerson extends Person implements Null {
        private NullPerson(){super("None","None","None");}
        public String toString(){return "NullPerson";}
    }
    public static final Person NULL = new NullPerson();
}
