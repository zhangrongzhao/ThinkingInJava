package com.thinkingInJava.chapter11.holding;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow{}
class Power extends Snow{}
class Light extends Power{}
class Heavy extends Power{}
class Crusty extends Snow{}
class Slush extends Snow{}
public class AsListInference {
    public static void main(String[] args){
        List<Snow> snow1= Arrays.asList(
                new Snow(),new Power(),new Crusty(),new Slush(),new Power(),new Light(),new Heavy());

        //List<Snow> snow2=Arrays.asList(new Light(),new Heavy());
        //显示告诉编译器，实际目标类型
        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3,new Light(),new Heavy());

        //告诉编译器，Arrays产生的List类型，实际的目标类型是什么。显示类型参数说明。
        List<Snow> snow4=Arrays.<Snow>asList(new Light(),new Heavy());
    }
}
