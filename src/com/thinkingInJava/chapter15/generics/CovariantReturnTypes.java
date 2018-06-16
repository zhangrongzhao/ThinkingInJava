package com.thinkingInJava.chapter15.generics;

/**
 * Created by rongzhao on 2018/6/16.
 */

class Base{}
class Derived extends Base{ }
interface OrdinaryGetter{
    Base get();
}

interface DerivedGetter extends OrdinaryGetter{
    //Return type of overridden method is allowed to vary.
    Derived get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter d){
        Derived d2=d.get();
    }
}
