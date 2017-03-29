package imooc.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:学生类，处理学生
 * Version:1.0
 * Created by leal
 * On 17-2-26:上午12:02.
 */
public class Student implements Comparable<Student>
{
    private String id;
    private String name;
    private Set Course;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return getName() != null ? getName().equals(student.getName()) : student.getName() == null;
    }

    @Override
    public int hashCode()
    {
        return getName() != null ? getName().hashCode() : 0;
    }

    public Student(String id, String name){
        this.id=id;
        this.name=name;
        this.Course=new HashSet();//Set是接口，只能通过实现类实例化
    }

    @Override
    public int compareTo(Student student)
    {
        //排序按照字符串的顺序
        return this.id.compareTo(student.id);
    }
}
