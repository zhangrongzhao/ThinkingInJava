package com.thinkingInJava.chapter12.exceptions;
//How an exception can be lost.

class VeryImportantException extends Exception{
    public String toString(){
        return "A very important exception!";
    }
}

class HoHumException extends Exception{
    public String toString(){
        return "A trivial excetpion";
    }
}

public class LostMessage {
    void f() throws VeryImportantException{
        throw new VeryImportantException();
    }
    void dispose()throws HoHumException{
        throw new HoHumException();
    }
    public static void main(String[] args){
        try{
            LostMessage lm=new LostMessage();
            try{
               lm.f();
            }finally {
               lm.dispose();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
