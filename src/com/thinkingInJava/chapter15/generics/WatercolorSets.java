package com.thinkingInJava.chapter15.generics;

import com.thinkingInJava.chapter15.generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.Set;

import static com.thinkingInJava.util.Sets.*;


public class WatercolorSets {
    public static void main(String[] args){
        Set<Watercolors> set1= EnumSet.range(Watercolors.BRILLIANT_RED,Watercolors.VIRIDIAN_HUE);
        Set<Watercolors> set2= EnumSet.range(Watercolors.CERULEAN_BLUE_HUE,Watercolors.BURNT_UMBER);
        System.out.println("set1:"+set1);
        System.out.println("set2:"+set2);
        System.out.println("union(set1,set2):"+union(set1,set2));

        Set<Watercolors> subset = intersection(set1,set2);
        System.out.println("intersection(set1,set2):" + subset);

        System.out.println("difference(set1,set2):" + difference(set1,subset));
        System.out.println("complement(set1,set2):"+complement(set1,set2));
    }

}
