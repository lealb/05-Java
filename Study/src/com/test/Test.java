package com.test;

/**
 * Description:
 * Version:v1.0
 * Created by Leal
 * on 2017/6/14:10:56.
 */
public class Test {
    public static void main(String[] args) {
//        int i=1;
//        while (i<128){
//            System.out.println(i);
//            i*=2;
//        }
        Thread thread=new Thread();
        test();
        thread.run();
        System.out.println("world");
    }

    public static  void test(){
        System.out.println("hello");
    }
}
