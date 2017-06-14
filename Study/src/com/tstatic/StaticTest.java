package com.test;

/**
 * Description:测试静态块
 * Version:v1.0
 * Created by Leal
 * on 2017/6/13:22:59.
 */
public class StaticTest {

    public static int a=0;
    static {
        a=10;
        System.out.println("父类的静态代码块执行,a="+a);
    }
    {
        a=8;
        System.out.println("父类的非静态代码块执行"+a);
    }

    public StaticTest(){
        this("a在父类带参构造方法中的值：" + StaticTest.a); // 调用另外一个构造方法
//        new StaticTest("sd");
        System.out.println(a);
        System.out.println("父类无参构造方法在执行a=" + a);
    }

    public StaticTest(String n){
        System.out.println(n);
        System.out.println(a+1);
    }

    public static void main(String[] args) {
        StaticTest test=null;
        System.out.println("11111");
        test=new StaticTest();
    }
}
