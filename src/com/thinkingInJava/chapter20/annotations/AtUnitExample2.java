package com.thinkingInJava.chapter20.annotations;

import com.thinkingInJava.util.OSExecute;
import com.thinkingInJava.util.atunit.Test;

import java.io.FileInputStream;
import java.io.IOException;

//Assertions and exceptions can be used in @Tests.
public class AtUnitExample2 {
    public String methodOne(){
        return "This is methodOne";
    }
    public int methodTwo(){
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test void assertExample(){
        assert methodOne().equals("This is methodOne");
    }

    @Test void assertFailureExample(){
        assert 1==2:"What a surprise!";
    }

    @Test void exceptionExample()throws IOException{
        new FileInputStream("nofile.txt");//throws.
    }

    @Test boolean asertAndReturn(){
        //Assertion with message:
        assert methodTwo()==2:"methodTwo must equal 2";
        return methodOne().equals("This is methodOne");
    }

    public static void main(String[] args)throws Exception{
        OSExecute.command("java com.thinkingInJava.chapter20.annotations AtUnitExample2");
    }
}
