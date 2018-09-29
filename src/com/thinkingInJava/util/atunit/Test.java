package com.thinkingInJava.util.atunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//The @Test tag
@Target(ElementType.METHOD)//目标：注解应用到什么地方
@Retention(RetentionPolicy.RUNTIME)//注解在哪一个级别可用：源代码(SOURCE),类文件(CLASS)或者运行时(RUNTIME
public @interface Test { }
