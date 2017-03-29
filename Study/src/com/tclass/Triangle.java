package com.tclass;

/**
 * Description:
 * Version:1.0
 * Created by leal
 * On 17-2-25:下午3:44.
 */
public  class Triangle extends Shape
{
    private double a;
    private double b;
    private double c;
    public Triangle(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    @Override
    public double getArea()
    {
        return 0.25*Math.sqrt((a+b+c)*(a+b-c)*(a-b+c)*(b+c-a));
    }

    @Override
    public double getPerimeter()
    {
        return a+b+c;
    }
}
