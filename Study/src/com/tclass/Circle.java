package com.tclass;

/**
 * Description:
 * Version:1.0
 * Created by leal
 * On 17-2-25:下午3:37.
 */
public class Circle extends Shape
{
    private final double PI=3.1415926;
    private double r;

    public Circle(double r){
        this.r=r;
    }

    @Override
    public double getArea()
    {
        return PI*r*r;
    }

    @Override
    public double getPerimeter()
    {
        return 2*PI*r;
    }
}
