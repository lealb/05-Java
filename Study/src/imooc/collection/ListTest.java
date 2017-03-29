package imooc.collection;

import java.util.*;

/**
 * Description:备选课程类
 * Version:1.0
 * Created by leal
 * On 17-2-26:上午12:09.
 */
public class ListTest
{
    private List coursesToSelect;

    public ListTest(){
        this.coursesToSelect=new ArrayList();
    }

    /**
     * 添加单个课程
     * @param id
     * @param name
     */
    public void addCourse(String id,String name){

        coursesToSelect.add(new Course(id,name));
    }

    /**
     * 批量添加课程
     * @param course
     */
    public void addAllCourse(Course[] course){

        //注意转换为arraylist
        coursesToSelect.addAll(Arrays.asList(course));
    }
    /**
     * 插入相应位置的课程
     * @param i 插入的位置
     * @param id 课程id
     * @param name 课程name
     */
    public void insertCourse(int i,String id,String name){

        Course course=new Course(id,name);
        try {
            coursesToSelect.add(i,course);
        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
            System.out.println("数组插入越界啦");
        }

    }
    //修改通过set
    //删除 Remove removeAll
    //public Course getCourse

    /**
     * 显示全部课程
     */
    public void showAllCourse(){
        //1.循环for
        System.out.println("待选课程：");
        int size=coursesToSelect.size();
        for (int i=0;i<size;i++){
            Course course= (Course) coursesToSelect.get(i);
            System.out.println(i+":"+course.getId()+"-"+course.getName());
        }

//        //2.使用迭代器
//        Iterator iterator=coursesToSelect.iterator();
//        while (iterator.hasNext()){
//            Course course= (Course) iterator.next();
//            System.out.println(course.getId()+":"+course.getName());
//        }
//
//        //3.使用for each
//        for(Object obj:coursesToSelect){
//            Course course= (Course) obj;
//            System.out.println(course.getId()+":"+course.getName());
//        }
    }



    /**
     * 判断选课是否包含名称/containsall
     */
    public void containsCourse(){
        System.out.println("请输入课程名称：");
        Scanner input=new Scanner(System.in);
        Course course=new  Course();
        String name=input.next();
        course.setName(name);
        System.out.println("课程包含："+course.getName()+"."+coursesToSelect.contains(course));
        //通过ondexof获得索引位置
        if(coursesToSelect.contains(course)){
            System.out.println("索引位置:"+coursesToSelect.indexOf(course));
        }
    }


}
