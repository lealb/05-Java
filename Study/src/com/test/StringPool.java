package com.test;

/**
 * Description: 字符池
 * Version:v1.0
 * Created by Leal
 * on 2017/6/14:0:36.
 */
public class StringPool {

    public static void main(String[] args) {
        String s1=new String("abc");//直接在堆中生成新的“abc”
        String s2=new String("abc");//直接在堆中生成新的“abc”
        //先去“字符数据池”搜索时候有“abc”这个字符串，如果有，则
        //将字符串的首地址赋值给s3，如果没有，则在“字符数据池”中生成一个新的字符串“abc”并且将首地
        // 址赋值给s3；
        String s3="abc";
        //去“字符数据池”搜索时发现了上一步生成的“abc”这个字符串
        //把该字符串首地址赋值给s4，这时其实s3和s4指向同一个字符数据池中的“abc”
        String s4="abc";
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s2==s3);
        System.out.println(s3==s4);

    }
}
