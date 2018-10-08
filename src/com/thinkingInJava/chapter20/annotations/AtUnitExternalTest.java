package com.thinkingInJava.chapter20.annotations;

import com.thinkingInJava.util.OSExecute;
import com.thinkingInJava.util.atunit.Test;

//Creating non-embedded tests.
public class AtUnitExternalTest  extends AtUnitExample1{
    @Test boolean _methodOne(){
        return methodOne().equals("This is methodOne");
    }

    @Test boolean _methodTwo(){
        return methodTwo()==2;
    }

    public static void main(String[] args)throws Exception{
        OSExecute.command("java com.thinkingInJava.chapter20.annotations AtUnitExternalTest");
    }
}
