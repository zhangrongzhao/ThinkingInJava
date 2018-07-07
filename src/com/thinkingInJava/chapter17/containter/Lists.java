package com.thinkingInJava.chapter17.containter;

import com.thinkingInJava.util.Countries;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;
    public static void basicTest(List<String> a){
        a.add(1,"X");//Add at location 1
        a.add("X");//Add at end
        //Add a collection
        a.addAll(Countries.names(6));
        //Add a collection starting at location 3:
        a.addAll(3,Countries.names(6));
        b = a.contains("1");//Is it there?
        //Is the entire collection in there?
        b = a.containsAll(Countries.names(6));
        //Lists allow random access,which is cheap for ArrayList,expensive for LinkedList:
        s=a.get(1);//Get typed object at location 1
        i=a.indexOf("1");//Tell index of object.
        b=a.isEmpty();//Any elements inside?
        it=a.iterator();//Ordinary Iterator
        lit=a.listIterator();//ListIterator
        lit=a.listIterator(3);//Start at loc 3
        i=a.lastIndexOf("1");//Last math
        a.remove(1);//Remove location 1
        a.remove("3");//Remove this object.
        a.set(1,"y");//set location 1 to "y";
        //Keep everything thatis in the argument (the intersectin of the two sets):
        a.retainAll(Countries.names(6));
        //Remove everything that's in the argument
        a.removeAll(Countries.names(6));
        i=a.size();//How big is it?
        a.clear();
    }
    public static void iterMotion(List<String> a){
        ListIterator<String> it=a.listIterator();
        b=it.hasNext();
        b=it.hasPrevious();
        s=it.next();
        i=it.nextIndex();
        s=it.previous();
        i=it.previousIndex();
    }
}
