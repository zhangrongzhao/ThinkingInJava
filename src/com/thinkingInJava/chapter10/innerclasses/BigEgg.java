package com.thinkingInJava.chapter10.innerclasses;

/**
 * Created by rongzhao on 2018/5/5.
 */
class Egg{
    private Yolk y;
    protected class Yolk{
        public Yolk(){System.out.println("Egg.Yolk()");}
    }
    public Egg(){
        System.out.println("New Egg()");
        y=new Yolk();
    }
}

public class BigEgg extends Egg{
    public class Yolk{
        public Yolk(){
            System.out.println("BigEgg.Yolk()");
        }
    }
    public static void main(String[] args){
        new BigEgg();
    }
    //该实例中，两个内部类完全独立。在各自的命名空间内。
}
