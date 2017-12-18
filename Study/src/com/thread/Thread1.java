package com.thread;

/**
 * Description: 线程测试
 * Version:v1.0
 * Created by leal
 * on 2017/8/4.
 */

public class Thread1 extends Thread {
    private String  name;
    public Thread1(String name){
        this.name=name;
    }

    public void run(){

        for (int i = 0; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName()+" Start");
            System.out.println(name + "->run: "+i);
            try {
                sleep((int)Math.random()*10);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" End");
    }
}
