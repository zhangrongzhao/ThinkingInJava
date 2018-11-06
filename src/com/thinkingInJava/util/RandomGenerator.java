package com.thinkingInJava.util;
import java.util.Random;

//Generators that produce random values.
public class RandomGenerator {
    private static Random r=new Random(47);
    public static class Boolean implements Generator<java.lang.Boolean>{
        public java.lang.Boolean next(){
            return r.nextBoolean();
        }
    }
    public static class Byte implements Generator<java.lang.Byte>{
        public java.lang.Byte next(){
            return (byte)r.nextInt();
        }
    }
    static char[] chars=("abcdefghijklmnopqrstuvwxyzABCDEFHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public static class Character implements Generator<java.lang.Character>{
        public java.lang.Character next(){
            return chars[r.nextInt(com.thinkingInJava.chapter16.arrays.CountingGenerator.chars.length)];
        }
    }
    public static class String extends  com.thinkingInJava.chapter16.arrays.CountingGenerator.String{
        { cg = new Character();}//Instance initializer
        public String(){}
        public String(int length){super(length);}
    }
    public static class Short implements Generator<java.lang.Short>{
        public java.lang.Short next(){return (short)r.nextInt();}
    }
    public static class Integer implements Generator<java.lang.Integer>{
        private int mod=10000;
        public Integer(){}
        public Integer(int modulo){mod=modulo;}
        public java.lang.Integer next(){return r.nextInt(mod);}
    }

    public static class Long implements Generator<java.lang.Long>{
        private int mod=10000;
        public Long(){}
        public Long(int modulo){mod=modulo;}
        public java.lang.Long next(){return new java.lang.Long(r.nextInt(mod));}
    }
    public static class Float implements Generator<java.lang.Float>{
        public java.lang.Float next(){
           //Trim all but the first two deimal places:
            int trimmed=Math.round(r.nextFloat()*100);
            return ((float)trimmed)/100;
        }
    }
    public static class Double implements Generator<java.lang.Double>{
        private double value=0.0;
        public java.lang.Double next(){
            long trimmed=Math.round(r.nextDouble()*100);
            return ((double)trimmed)/100;
        }
    }
}
