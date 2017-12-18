package com.thread;

/**
 * Description:
 * Version:v1.0
 * Created by Leal
 * on 2017/6/14:10:56.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" Start");
        Thread1 thread1=new Thread1("A");
        Thread1 thread2=new Thread1("B");
        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getName()+" End");
    }
}
