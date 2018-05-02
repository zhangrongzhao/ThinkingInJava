package com.thinkingInJava.chapter10.innerclasses;

public class Parcel3 {
    //内部类
    class Contents{
        private int i=11;
        public int value(){return i;}
    }

    class Destination{
        private String label;
        Destination(String whereTo){
            this.label=whereTo;
        }

        String readLabel(){return this.label;}
    }

    public static void main(String[] args){
        Parcel3 p=new Parcel3();
        Parcel3.Contents c=p.new Contents();
        Parcel3.Destination d=p.new Destination("beijing");
        //Note:外部类实例对象创建后，才能创建内部类实例对象。内部类名字作用域：作用在外部类实例对象上
    }
}
