package com.thinkingInJava.chapter20.annotations;

import com.thinkingInJava.util.OSExecute;
import com.thinkingInJava.util.atunit.Test;

public class AtUnitExample1 {
    public String methodOne(){
        return "This is methodOne";
    }
    public int methodTwo(){
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test boolean methodOneTest(){
        return methodOne().equals("This is methodOne");
    }

    @Test boolean m2(){return methodTwo()==2;}

    @Test private boolean m3(){return true;}

    //Shows output for failure:
    @Test boolean failureTest(){return false;}

    @Test boolean anotherDisappointment(){return false;}

    public static void main(String[] args)throws Exception{
        OSExecute.command("java com.thinkingInJava.chapter20.annotations AtUnitExample1");
    }
}
