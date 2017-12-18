package com.test;

import java.util.ArrayList;
import java.util.Date;

/**
 * Description:
 * Version:v1.0
 * Created by leali
 * on 2017/10/3；18:51.
 */

public class Testlist {
    public static void main(String[] args) {
        String id ="123";
        String name ="Leal";

        ArrayList<String> datalist =new ArrayList<>();
        datalist.add(id+","+name);

//        for(String dl:datalist){
//            System.out.println(dl);
//        }
        int i=10,j=20;
        while (i++<--j){

        }
        System.out.println(i+" "+j);
        System.out.println(new Date());

    }
}
