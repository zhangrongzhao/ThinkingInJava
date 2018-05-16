package com.thinkingInJava.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ContainerMethodDefferences {
    static Set<String> methodSet(Class<?> type){
        Set<String> result=new TreeSet<String>();
        for(Method m:type.getMethods()){
            result.add(m.getName());
        }
        return result;
    }

    static void interfaces(Class<?> type){
        System.out.println("Interfaces in "+type.getSimpleName()+":");
        List<String> result=new ArrayList<String>();
        for(Class<?> c:type.getInterfaces()){
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }

    static Set<String> object=methodSet(Object.class);
    static {object.add("clone");}
    static void difference(Class<?> superSet,Class<?> subset){
        System.out.println(superSet.getSimpleName()+",adds:");
        Set<String> comp=Sets.difference(methodSet(superSet),methodSet(subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superSet);
    }
}
