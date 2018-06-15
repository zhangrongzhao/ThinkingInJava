package com.thinkingInJava.chapter15.generics;


class Hamster extends ComparablePet implements Comparable<ComparablePet>{
    public int compareTo(ComparablePet arg){
        return 0;
    }
}

class Gecko extends ComparablePet{
    public int compareTo(ComparablePet arg){
        return 0;
    }
}

//class SelfBounded<T extends SelfBounded<T>>{ }


public class RestrictedComparablePets {
}
