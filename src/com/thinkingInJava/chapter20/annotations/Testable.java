package com.thinkingInJava.chapter20.annotations;

import com.thinkingInJava.util.atunit.Test;

public class Testable {
    public void execute(){
        System.out.println("Executing...");
    }
    @Test
    void testExecute(){
        execute();
    }
}
