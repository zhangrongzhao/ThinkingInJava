package com.thinkingInJava.util.atunit;

import com.thinkingInJava.util.ProcessFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//An annotation-based unit-test framework.
//{RunByHand}
public class AtUnit implements ProcessFiles.Strategy {
    static Class<?> testClass;
    static List<String> failedTests=new ArrayList<String>();
    static long testsRun=0;
    static long failures=0;
    public static void main(String[] args)throws Exception{

    }
    public void process(File cFile){

    }
}
