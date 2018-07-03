package com.thinkingInJava.chapter14.typeinfo;

import com.thinkingInJava.chapter14.typeinfo.InterfaceViolation.A;

class AnonymousA{
    public static A makeA(){
        return new A(){
            public void f(){System.out.println("public C.f()");}
            public void g(){System.out.println("public C.g()");}
            void u(){System.out.println("package C.u()");}
            protected  void v(){System.out.println("protected C.v()");}
            private void w(){System.out.println("private C.w()");}
        };
    }
}

public class AnonymousImplementation {
    public static void main(String[] args)throws Exception{
        A a=AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        //Reflection still gets into the private class.
        HiddenImplementation.callHiddenMethod(a,"g");
        HiddenImplementation.callHiddenMethod(a,"u");
        HiddenImplementation.callHiddenMethod(a,"v");
        HiddenImplementation.callHiddenMethod(a,"w");
    }
}
