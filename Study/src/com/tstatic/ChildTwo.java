package com.tstatic;

/**
 * Description:
 * Version:v1.0
 * Created by Leal
 * on 2017/6/13:23:21.
 */
public class ChildTwo extends Father {
    static {
        System.out.println("ChildTwo static Create");
    }

    {
        System.out.println("ChildTwo Create");
    }

    public static void StaticFunction() {
        System.out.println("ChildTwo static Function");
    }

    public void Function() {
        System.out.println("ChildTwo Function");
    }

}
