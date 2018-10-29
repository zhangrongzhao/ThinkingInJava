package com.thinkingInJava.chapter13.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
    static public final String POEM="Twas brillig, and the slithy toves\n" +"" +
            "Did gyre and fimble in the wabe.\n"+
            "All mimsy were the borogoves,\n"+
            "And the mome raths outgrabe.\n"+
            "Beware the jabberwock, my son,\n" +
            "The jaws that bite, the claws that catch.\n"+
            "Beware the jubjub bird, and shum\n"+
            "The firmious Bandersnatch.";
    public static void main(String[] args){
        Matcher m= Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        while(m.find()){
            for(int j=0;j<=m.groupCount();j++){
                System.out.println("["+m.group(j)+"]");
            }
            System.out.println();
        }
    }
}
