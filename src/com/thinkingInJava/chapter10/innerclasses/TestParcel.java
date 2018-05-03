package com.thinkingInJava.chapter10.innerclasses;

class Parcel4 {
    //私有内部类，仅Parcel4可以访问。外部类对该类不可访问，不可见。
    private class PConents implements Contents{
        private int i=11;
        public int value(){return i;}
    }

    protected class PDestination implements Destination{
        private String label;
        //私有构造函数，外部不能直接实例化
        private PDestination(String whereTo){
            this.label=whereTo;
        }
        public String readLabel(){return label;}
    }

    public Destination destination(String s){
        return new PDestination(s);
    }

    public Contents contents(){
        return new PConents();
    }
}

public class TestParcel{
     public static void main(String[] args){
         Parcel4 p=new Parcel4();
         Contents c=p.contents();
         Destination d=p.destination("Tasmania");
     }
}

//NOTE:内部类型对外不可见，可以阻止外部代码依赖内部类型。将实现细节完全隐藏在内部。
