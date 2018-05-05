package com.thinkingInJava.chapter10.innerclasses;

/**
 * Created by rongzhao on 2018/5/5.
 */
class WithInner{
    class Inner{}
}

public class InheritInner extends WithInner.Inner {
    InheritInner(WithInner wi){
        wi.super();
    }
    public static void main(String[] args){
        WithInner wi=new WithInner();
        InheritInner ii=new InheritInner(wi);
    }
}
