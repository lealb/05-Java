package imooc.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 测试泛型
 * Version:1.0
 * Created by leal
 * On 17-2-26:下午3:35.
 */
public class TestGeneric
{
    private List<Course>courses;

    public List<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }

    public TestGeneric(){
        this.courses=new ArrayList<Course>();
    }

    public void addCourse(){
        Course course = new Course("5","大学语文");
        courses.add(course);
    }

    public void showCourses(){
        for(Course course:courses){
            System.out.println(course.getId()+":"+course.getName());
        }
    }
}
