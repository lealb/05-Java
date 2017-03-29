package com.tclass;

/**
 * Description: 慕课网测试
 * Version:1.0
 * Created by leal
 * On 17-2-24:下午1:55.
 */
public class Study
{
    private String name;
    private char sex;
    private static int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public char getSex()
    {
        return sex;
    }

    public void setSex(char sex)
    {
        this.sex = sex;
    }

    public static int getAge()
    {
        return age;
    }

    public static void setAge(int age)
    {
        Study.age = age;
    }

    //构造方法
    public Study(){
        System.out.println("构造方法初始化对象");
        name="Tom";
    }
    //初始化块
    {
        System.out.println("初始化块初始化对象");
        sex='M';
    }
    //静态初始化块
    static {
        System.out.println("静态初始化对象");
        age=20;
    }
    public void show(){
        System.out.println("姓名："+name+"\n性别："+sex+"\n年龄："+age);
    }
}
