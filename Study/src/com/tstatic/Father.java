package com.tstatic;

/**
 * Description: Test Static
 * Version:v1.0
 * Created by Leal
 * on 2017/6/13:23:17.
 */
public class Father {
    static {
        System.out.println("Father static Created");
    }
    {
        System.out.println("Father Created");
    }
    public static void StaticFunction(){
        System.out.println("Father static Function");
    }
    public void Function(){
        System.out.println("Father Function");
    }
}
