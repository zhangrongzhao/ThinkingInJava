package com.thinkingInJava.chapter12.exceptions;
//Demonstrating the exception methods.
public class ExceptionMethods {
    public static void main(String[] args){
        try{throw new Exception("Exception");}catch(Exception e){
            System.out.println("Caught Exception");
            System.out.println("getMessage():"+e.getMessage());
            System.out.println("getLocalizedMessage():"+e.getLocalizedMessage());
            System.out.println("toString():"+e);
            System.out.println("printStackTrace();");
            e.printStackTrace(System.out);
        }
    }
}
