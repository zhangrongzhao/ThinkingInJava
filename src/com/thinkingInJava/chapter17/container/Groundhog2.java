package com.thinkingInJava.chapter17.container;

public class Groundhog2  extends Groundhog{
    public Groundhog2(int n){super(n);}
    public String toString(){
        return "Groundhog #"+number;
    }
    public int hashCode(){
        return this.number;
    }
    public boolean equals(Object obj){
        return obj instanceof Groundhog &&this.number==((Groundhog)obj).number;
    }
}
