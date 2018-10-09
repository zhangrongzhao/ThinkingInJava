package com.thinkingInJava.chapter20.annotations;

import com.thinkingInJava.util.OSExecute;
import com.thinkingInJava.util.atunit.Test;

import java.io.IOException;
import java.io.PrintWriter;

public class AtUnitExample5 {
    private String text;
    public AtUnitExample5(String text){this.text=text;}
    public String toString(){return text;}
//    @TestProperty static PrintWriter output;
//    @TestProperty static int counter;
//    @TestObjectCreate static AtUnitExample5 create(){
//        String id=Integer.toString(counter++);
//        try{
//            output=new PrintWriter("Test"+id+".txt");
//        }catch(IOException e){
//            throw new RuntimeException(e);
//        }
//        return new AtUnitExample5(id);
//    }
//    @TestObjectCleanup static void cleanup(AtUnitExample5 tobj){
//        System.out.println("Running cleanup");
//        output.close();
//    }
//    @Test boolean test1(){
//        output.print("test1");
//        return true;
//    }
//
//    @Test boolean test2(){
//        output.print("test2");
//        return true;
//    }
//
//    @Test boolean test3(){
//        output.print("test3");
//        return true;
//    }
    public static void main(String[] args)throws Exception{
        OSExecute.command("java com.thinkingInJava.chapter20.annotations AtUnitExample5");
    }
}
