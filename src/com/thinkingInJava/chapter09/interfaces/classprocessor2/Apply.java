package com.thinkingInJava.chapter09.interfaces.classprocessor2;

import java.util.Arrays;

class Upcase extends StringProcessor {
    public String process(Object input){//Covariant return
          return ((String)input).toUpperCase();
    }
}

class Downcase extends StringProcessor {
    public String process(Object input){//Covariant return
        return ((String)input).toLowerCase();
    }
}

class Splitter extends StringProcessor {
    public String process(Object input){
        //The split() argument divides a String into pieces:
        return Arrays.toString(((String)input).split(" "));
    }
}

public class Apply {
    public static void process(Processor p, Object s){
        System.out.println("Using Processor "+p.name());
        System.out.println(p.process(s));
    }
    public static String s="Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args){
        process(new Upcase(),s);
        process(new Downcase(),s);
        process(new Splitter(),s);
    }
}
