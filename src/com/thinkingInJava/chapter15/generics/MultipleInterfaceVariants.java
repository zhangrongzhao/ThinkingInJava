package com.thinkingInJava.chapter15.generics;

interface Payable<T>{}

class Employee implements Payable<Employee>{}
//class Hourly extends Employee implements Payable<Hourly>{
//  //不能编译，运行时擦除泛型参数，Hourly两次实现相同的接口
//}
public class MultipleInterfaceVariants {
}
