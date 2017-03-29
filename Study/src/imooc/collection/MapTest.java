package imooc.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Description:
 * Version:1.0
 * Created by leal
 * On 17-2-26:下午4:28.
 */
public class MapTest
{
    private Map<String,Student>studentMap;

    public MapTest(){
        this.studentMap=new HashMap<>();
    }

    public void addStudent(){
        //循环三次添加
        Scanner input=new Scanner(System.in);
        int i=0;
        while (i<3){
            System.out.print("输入编号:");
            String id=input.next();
            Student stu=studentMap.get(id);
            if(stu!=null){
                System.out.println("已存在");
            }else{
                i++;
                System.out.print("输入姓名:");
                String name=input.next();
                studentMap.put(id,new Student(id,name));
            }
        }
    }

    /**
     * KetSet
     */
    public void showStudents(){
        Set<String>keySet=studentMap.keySet();//获得所有键的集合
        System.out.println("学生人数:"+studentMap.size());
        for(String stuId:keySet){
            Student student=studentMap.get(stuId);
            if(student!=null){
                System.out.println(student.getId()+":"+student.getName());
            }

        }

    }

    public  void showStudentsByEntry(){
        //通过entryset，返回MAP所有键值对
        Set<Map.Entry<String, Student>> entrySet=studentMap.entrySet();
        for (Map.Entry<String,Student> entry:entrySet){
            System.out.println(entry.getKey()+":"+entry.getValue().getId()+"-"+entry.getValue().getName());
        }

    }

    /**
     * 删除学生
     */
    public void removeStudent(){
        System.out.println("请输入删除编号啊:");
        Scanner input=new Scanner(System.in);
        String id=input.next();
        Student stuId=studentMap.get(id);
        while (true){
            if(stuId==null){
                System.out.println("不存在血红色呢过");
                continue;
            }
            studentMap.remove(id);
            System.out.println("成功删除啦:"+stuId.getName());
            break;
        }
    }

    /**
     * 测试Map中是否包含某个的key/value值
     */
    public void containsKeyOrValue(){

        System.out.println("请输入方式：1.学生id 2.学生name");
        Scanner input=new Scanner(System.in);
        int ways=input.nextInt();
        switch (ways){
            case 1:
            {
                System.out.println("请输入学生id:");
                String id=input.next();
                System.out.println("id:"+id+"."+studentMap.containsKey(id));
                if(studentMap.containsKey(id)){
                    System.out.println("name:"+studentMap.get(id).getName());
                }
                break;
            }
            case 2:
            {
                System.out.println("请输入学生name:");
                String name=input.next();
                System.out.println("name:"+name+"."+studentMap.containsValue(new Student(null,name)));
                if(studentMap.containsValue(new Student(null,name))){
                    //NullPointerException 空指针异常
                    System.out.println("name:"+studentMap.get(new Student(null,name)).getId());
                }
                break;
            }
            default:{
                System.out.println("输入数字错误！");
            }
        }

    }
}
