package imooc.collection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Description:
 * Version:1.0
 * Created by leal
 * On 17-2-26:下午4:13.
 */
public class SetTest
{
    private Set<Course>courseSet;

    public SetTest(){
        this.courseSet=new HashSet<>();
    }

    /**
     * 通过set添加课程
     */
    public void addCourse(){
        Course course=new Course("1","setsd");
        courseSet.add(course);
    }

    /**
     * 显示
     */
    public void showCourses(){
        for (Course course:courseSet){
            System.out.println(course.getId()+":"+course.getName());
        }
    }

    /**
     * 判断选课是否包含名称/containsall
     */
    public void containsCourseBySet(){

    }
}
