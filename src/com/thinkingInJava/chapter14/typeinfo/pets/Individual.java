package com.thinkingInJava.chapter14.typeinfo.pets;

public class Individual implements Comparable<Individual>{
    private static long counter = 0;
    private final long id = counter++;
    private String name = "";

    public Individual(){ }
    public Individual(String name){this.name=name;}

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.getClass().getSimpleName()+(name==null?" ":" "+name);
    }

    public int hashCode(){
        int result = 17;
        if(name!=null){
            result = 37 * result + name.hashCode();
        }
        result = 37 * result + (int)id;
        return result;
    }
    public boolean equals(Object o){
        return o instanceof Individual && id==((Individual)o).id ;
    }

    public int compareTo(Individual arg){
        //Compare by class name first:
        String first=getClass().getSimpleName();
        String argFirst=arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if(firstCompare!=0) return firstCompare;
        if(name!=null&&arg.name!=null){
            int secondCompare=name.compareTo(arg.name);
            if(secondCompare!=0){
                return secondCompare;
            }
        }
        return arg.id<id?-1:(arg.id==id?0:1);
    }
}