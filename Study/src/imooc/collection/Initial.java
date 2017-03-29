package imooc.collection;

import java.util.Random;

/**
 * Description:
 * Version:1.0
 * Created by leal
 * On 17-2-26:上午12:18.
 */
public class Initial
{
    public static void main(String []args){
        ListTest listTest=new ListTest();
        listTest.addCourse("1", "数据结构");
        Course []course =new Course[]{new Course ("2","高等数学"),new Course("3","C语言")};
        listTest.addAllCourse(course);
        //测试 插入
        listTest.insertCourse(3,"4","单片机");
        listTest.showAllCourse();
//        listTest.containsCourse();
        System.out.println("*****This is a ******");
        //Test Generic
//        TestGeneric testGeneric=new TestGeneric();
//        testGeneric.addCourse();
//        testGeneric.showCourses();
//        System.out.println("*****This is a ******");
        //Test Set
//        SetTest setTest=new SetTest();
//        setTest.addCourse();
//        setTest.showCourses();
//        System.out.println("*****This is a ******");
        //Test Map
//        MapTest mapTest=new MapTest();
//        mapTest.addStudent();
//        mapTest.containsKeyOrValue();
//        mapTest.showStudents();
//        mapTest.removeStudent();
//        mapTest.showStudentsByEntry();

        //Test Collection
        CollectionTest collectionTest=new CollectionTest();
//        collectionTest.sortNums();
//        collectionTest.sortString();
        collectionTest.sortGeneric();
    }
}
