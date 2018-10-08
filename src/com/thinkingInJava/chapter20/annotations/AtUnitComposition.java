package com.thinkingInJava.chapter20.annotations;

import com.thinkingInJava.util.OSExecute;
import com.thinkingInJava.util.atunit.Test;

//Creating non-embedded tests.
public class AtUnitComposition {
    AtUnitExample1 testObject=new AtUnitExample1();
    @Test boolean _methodOne(){ return testObject.methodOne().equals("This is methodOne");}
    @Test boolean _methodTwo(){return testObject.methodTwo()==2;}
    public static void main(String[] args)throws Exception{
        OSExecute.command("java com.thinkingInJava.chapter20.annotations AtUnitComposition");
    }
}
