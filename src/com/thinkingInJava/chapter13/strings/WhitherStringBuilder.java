package com.thinkingInJava.chapter13.strings;

public class WhitherStringBuilder {
    public String implicit(String[] fields){
        String result="";
        for(int i=0;i<fields.length;i++){
            result+=fields[i];
        }
        return result;
    }
    public String explicit(String[] fields){
        StringBuilder result=new StringBuilder();
        for(int i=0;i<fields.length;i++){
            result.append(fields);
        }
        return result.toString();
    }
}
