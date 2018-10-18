package com.thinkingInJava.chapter19.enumerated;

import com.thinkingInJava.util.Enums;

enum Activity{SITTING,LYING,STANDING,HOPPING,RUNNING,DODGING,JUMPING,FALLING,FLYING}
public class RandomTest {
    public static void main(String[] args){
        for(int i=0;i<20;i++){
            System.out.print(Enums.random(Activity.class) + " ");
        }
    }
}
