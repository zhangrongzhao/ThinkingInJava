package com.thinkingInJava.chapter20.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases,Class<?> clazz){
        for(Method m:clazz.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc!=null){
                System.out.println("Found Use Case:"+uc.id()+" "+uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for(int i:useCases){
            System.out.println("Warning:Missing use case-"+i);
        }
    }
    public static void main(String[] args){
        List<Integer> userCases=new ArrayList<Integer>();
        Collections.addAll(userCases,47,48,49,50);
        trackUseCases(userCases,PasswordUtils.class);
    }
}
