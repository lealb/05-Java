package imooc.collection;

/**
 * Description: 课程类
 * Version:1.0
 * Created by leal
 * On 17-2-26:上午12:06.
 */
public class Course
{
    private String id;
    private String name;

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

    public Course(){

    }
    public Course(String id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        return getName() != null ? getName().equals(course.getName()) : course.getName() == null;
    }

    @Override
    public int hashCode()
    {
        return getName() != null ? getName().hashCode() : 0;
    }
}
