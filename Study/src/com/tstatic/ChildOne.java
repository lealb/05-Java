package com.tstatic;

/**
 * Description:
 * Version:v1.0
 * Created by Leal
 * on 2017/6/13:23:20.
 */
public class ChildOne extends Father {
    static {
        System.out.println("ChildOne static Create");
    }

    {
        System.out.println("ChildOne Create");
    }

    public static void StaticFunction() {
        System.out.println("ChildOne static Function");
    }
}
