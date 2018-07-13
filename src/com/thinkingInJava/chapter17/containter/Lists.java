package com.thinkingInJava.chapter17.containter;

import com.thinkingInJava.util.Countries;

import java.util.*;

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
        i=it.nextIndex();
        s=it.next();

        b=it.hasPrevious();
        i=it.previousIndex();
        s=it.previous();
    }
    public static void iterManipulation(List<String> a){
        ListIterator<String> it=a.listIterator();
        it.add("47");
        //Must move to an element after add();
        it.next();
        //Remove the element after the newly produced one:
        it.remove();
        //Must move to an element after remove()
        it.next();
        //Change the element after the deleted one :
        it.set("47");
    }
    public static void testVisual(List<String> a){
         System.out.println(a);
         List<String> b=Countries.names(6);
         System.out.println("b="+b);
         a.addAll(b);
         System.out.println("a="+a);
         a.addAll(b);
         System.out.println("a="+a);
         //Insert,remove,and replace elements
         //using a ListIterator:
         ListIterator<String> x = a.listIterator(a.size()/2);
         x.add("one");
         System.out.println(a);
         System.out.println(x.next());
         System.out.println(a);
         x.remove();
         System.out.println(a);
         System.out.println(x.next());
         System.out.println(a);
         x.set("47");
         System.out.println(a);
         //Traverse the list backwards:
         x = a.listIterator(a.size());
         while(x.hasPrevious()){
             System.out.println(x.previous()+" ");
         }
         System.out.println();
         System.out.println("testVisual finished");
    }
    public static void testLinkedList(){
        LinkedList<String> l1=new LinkedList<String>();
        l1.addAll(Countries.names(25));
        System.out.println(l1);
        //Treat it like a stack,pushing
        l1.addFirst("one");
        l1.addFirst("two");
        System.out.println(l1);
        //Like "peeking" at the top of a stack
        System.out.println(l1.getFirst());
        //Like popping a stack:
        System.out.println(l1.removeFirst());
        System.out.println(l1.removeFirst());
        //Treat it like a queue,pulling elements off the tail end;
        System.out.println(l1.removeLast());
        System.out.println(l1);
    }
    public static void main(String[] args){
        //Make and fill a new list each time:
        basicTest(new LinkedList<String>(Countries.names(6)));
        basicTest(new ArrayList<String>(Countries.names(6)));
        iterMotion(new LinkedList<String>(Countries.names(6)));
        iterMotion(new ArrayList<String>(Countries.names(6)));
        iterManipulation(new LinkedList<String>(Countries.names(6)));
        iterManipulation(new ArrayList<String>(Countries.names(6)));
        testVisual(new LinkedList<String>(Countries.names(6)));
        testVisual(new ArrayList<String>(Countries.names(6)));
        testLinkedList();
    }
}
