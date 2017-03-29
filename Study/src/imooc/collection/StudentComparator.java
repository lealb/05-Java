package imooc.collection;

import java.util.Comparator;

/**
 * Description: 实现Comparator接口比较name
 * Version:1.0
 * Created by leal
 * On 17-2-26:下午11:31.
 */
public class StudentComparator implements Comparator<Student>
{

    @Override
    public int compare(Student student, Student t1)
    {
        return student.getName().compareTo(t1.getName());
    }
}
