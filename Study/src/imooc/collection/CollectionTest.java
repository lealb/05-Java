package imooc.collection;

import java.util.*;

/**
 * Description:
 * Version:1.0
 * Created by leal
 * On 17-2-26:下午8:31.
 */
public class CollectionTest
{
    /**
     * 排序数字
     */
    public void sortNums(){
        List<Integer> numslist=new ArrayList<Integer>();
        Random random=new Random();
        Integer k;
        for(int i=0;i<10;i++){
            do{
                k=random.nextInt(100);
//                k=(int)(1+Math.random()*100-1+1);
                // 如果不是大量的运算的话，就可以用Math.random了，
                // 因为他可以运算起来慢一些，浮点之后再取整
            }while (numslist.contains(k));
            numslist.add(k);
        }
        System.out.println("排序前：");
        for (Integer list:numslist){
            System.out.print(list+" ");
        }
        System.out.println("");
        Collections.sort(numslist);
        System.out.println("排序后：");
        for (Integer list:numslist){
            System.out.print(list+" ");
        }
    }

    /**
     * 排序字符串
     * 1.10条随机字符串，长度小于10
     * 2.字符可以重复，生成的字符串不可重复
     */
    public void sortString(){
        List<String> stringList=new ArrayList<String>();
        Random random=new Random();
        String string="0123456789qazwsxedcrfvtgbyhnujmiklopQAZWSXEDCRFVTGBYHNUJMIKLOP";//10+26+26
        for(int i=0;i<10;i++){
            String getstring="";
            do{
                for(int j=0;j<random.nextInt(11)+1;j++){
                    getstring+=string.charAt(random.nextInt(62));
                }
            }while (stringList.contains(getstring));
            stringList.add(getstring);
        }

        System.out.println("排序前：");
        for (String list:stringList){
            System.out.print(list+" ");
        }
        System.out.println("");
        Collections.sort(stringList);
        System.out.println("排序后：");
        for (String list:stringList){
            System.out.print(list+" ");
        }
    }

    /**
     * 对泛型进行排序
     */
    public void sortGeneric(){

        //产生不重复的数字
        Object[] values = new Object[3];
        Random random = new Random();
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        //生成随机数字并存入HashMap
        for(int i = 0;i < values.length;i++){
            int number = random.nextInt(1000) + 1;
            hashMap.put(number, i);
        }
        // 从HashMap导入数组
        values = hashMap.keySet().toArray();
        //创建作为排序的学生列表
        List<Student> studentList=new ArrayList<Student>();
        studentList.add(new Student(values[0]+"","jane"));
        studentList.add(new Student(values[1]+"","jack"));
        studentList.add(new Student(values[2]+"","lidan"));
        System.out.println("排序前");
        for (Student student:studentList){
            System.out.println(student.getId()+":"+student.getName());
        }
        System.out.println("排序后");
        Collections.sort(studentList);
        for (Student student:studentList){
            System.out.println(student.getId()+":"+student.getName());
        }
        System.out.println("排序名字:");
        Collections.sort(studentList,new StudentComparator());
        for (Student student:studentList){
            System.out.println(student.getId()+":"+student.getName());
        }
    }
}
