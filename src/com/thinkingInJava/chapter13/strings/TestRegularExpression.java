package com.thinkingInJava.chapter13.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Allows you to easily try out regular expressions.
//{Args:abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}"}
public class TestRegularExpression {
    public static void main(String[] args){
//        if(args.length<2){
//            System.out.println("Usage:\n java TestRegularExpress characterSequence regular Expression+");
//            System.exit(0);
//        }
//        System.out.println("Input:\""+args[0]+"\"");
        String[] strs = new String[]{"abcabcabcdefabc","abc+","(abc)+","(abc){2,}"};
        for(String arg:strs){
            System.out.println("Regular expression:\""+arg+"\"");
            Pattern p=Pattern.compile(arg);
            Matcher m=p.matcher(arg);
            while(m.find()){
                System.out.println("Match\""+m.group()+"\" at positions "+m.start()+"-"+(m.end()-1));
            }
        }
    }
}
