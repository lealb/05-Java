package com.tclass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Initial {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {
//        TestForeach();
//        FororEach();
//        int []scores={89 , -23 , 64 , 91 , 119 , 52 , 73};
        Initial init = new Initial();
        Scanner input = new Scanner(System.in);
//        hello.getTop3(scores);
        //类的使用
//        Study study=new Study();
//        study.show();
        //抽象实现调用
//        System.out.println(new Circle(3).getArea());
//        System.out.println(new Circle(3).getPerimeter());
//        System.out.println(new Triangle(3,4,5).getArea());
//        System.out.println(new Triangle(3,4,5).getPerimeter());
        //测试异常
//        init.throwException();
        //init.guessGame();
    }

    /**
     * 测试foreach使用 **
     */
    public static void TestForeach() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        System.out.println("×这是分割线");

        //JDK8 only use
        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
            if ("E".equals(k)) {
                System.out.println("Initial E");
            }
        });
    }

    /**
     * 循环测试
     */
    public static void FororEach() {

        int[] array = {12, 32, 14, -2, 23, 63, 27};
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("*********");
        for (int ar : array) {
            System.out.println(ar);
        }
        System.out.println("*******");
        System.out.println(Arrays.toString(array));
    }

    /**
     * Get top 3.
     * 得到前三
     *
     * @param scores the scores
     */
    public void getTop3(int[] scores) {

        Arrays.sort(scores);
        int num = 0;
        for (int i = scores.length - 1; i >= 0 && num < 3; i--) {
            if (scores[i] < 0 || scores[i] > 100)
                continue;
            num++;
            System.out.println(scores[i]);
        }
    }

    /**
     * 测试异常处理
     */
    public void throwException() {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Input:");
            int a = input.nextInt();
            int b = input.nextInt();
            System.out.println(a / b);
        } catch (InputMismatchException ex) {
            ex.printStackTrace();
            System.err.println("这是非数字异常" + ex.toString());
        } catch (ArithmeticException ex) {
            System.err.println("这是算术异常");
        } finally {
            System.out.println("finally");
        }
    }

}
