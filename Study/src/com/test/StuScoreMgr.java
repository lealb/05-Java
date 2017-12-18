package com.test;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * 问题描述：
 * 1.录入5名学生2们课程的学生信息成绩信息存入 txt
 * 2.计算总成绩+其他信息 存入 sort.txt
 * 3.统计学生平均成绩、不及格比例、及格比例、优良中比例
 * 优化 封装一下写入 读出文件的方法
 */
class StuScoreMgr
{
    /**
     * 程序入口主函数
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        //实例化对象
        StuScoreMgr stu=new StuScoreMgr();
        for(int i=0;i<5;i++)
        {
            s[i]=new StuScoreMgr();
        }
        stu.menu();
    }
    private static StuScoreMgr[] s=new StuScoreMgr[5]; //录入学生上限
    int n=0;
    //定义一个全局的文件存入路径，可根据实际情况更改
    String filePath="D://student.txt";
    //学生信息
    private String name;
    private int num;
    private String classAge;
    //课程信息
    private double chinese;
    private double  math;

    /**
     * 判断文件中是否有学生信息
     * @throws IOException
     */
    public void isStuExist() throws IOException
    {
        char ch;
        String str;
        Scanner In=new Scanner(System.in);
        File file=new File(filePath);
        if(!file.exists())
        {
            System.out.println("你还没有录入任何学生信息，是否录入(Y/N):");
            str=In.next();
            ch=str.charAt(0);
            while(ch!='Y'&&ch!='y'&&ch!='N'&&ch!='n')
            {
                System.out.println("输入有误，请重新输入:");
                str=In.next();
                ch=str.charAt(0);
            }
            if(ch=='Y'||ch=='y')
            {
                this.add();
            }
            if(ch=='N'||ch=='n')
            {
                this.menu();
            }
        }
    }

    /**
     * 主菜单
     * @throws IOException 抛出异常
     */
    public void menu() throws IOException{

        int a;
        Scanner in=new Scanner(System.in);
        System.out.println("*************学生信息管理系统*************");
        System.out.println("*****        1.录入学生信息            ******");
        System.out.println("*****        2.显示学生信息            ******");
        System.out.println("*****        3.修改学生信息            ******");
        System.out.println("*****        4.删除学生信息            ******");
        System.out.println("*****        5.查看学生信息            ******");
        System.out.println("*****        6.成绩排序存入            ******");
        System.out.println("*****        7.成绩统计详情            ******");
        System.out.println("*****        0.退出管理系统            ******");
        System.out.println("******************************************");
        System.out.print("请选择(0~7):");
        a=in.nextInt();
        while(a<0||a>7)
        {
            System.out.print("输入无效，请重新输入:");
            a=in.nextInt();
        }
        switch(a)
        {
            case 1:this.add();break;
            case 2:this.show();break;
            case 3:this.modify();break;
            case 4:this.delete();break;
            case 5:this.look();break;
            case 6:this.saveSort();break;
            case 7:this.countSorce();break;
            case 0:{
                System.out.println("成功退出系统！！！");
                System.exit(0);
                break;
            }
            default:
                System.out.println("输入错误！请检查后输入");

        }
    }

    /**
     * 学生成绩录入
     * @throws IOException
     */
    public void add() throws IOException
    {
        String str,str1;
        int i,num1,t=1;
        char ch,ch1;

        Scanner In=new Scanner(System.in);
        while(t==1)
        {
            System.out.println("请输入学生学号:");
            num1=In.nextInt();

            //判断学号是否重复  
            for(i=0;i<n;i++)
            {
                while(s[i].num==num1)
                {
                    System.out.println("已存在此学号，请重新输入");
                    System.out.print("请输入学号:");
                    num1=In.nextInt();
                }
            }
            s[n].num=num1;
            System.out.println("请输入学生姓名:");
            s[n].name=In.next();
            System.out.println("请输入学生班级:");
            s[n].classAge=In.next();
            System.out.println("请输入学生语文成绩:");
            s[n].chinese=In.nextDouble();
            if(s[n].chinese<0||s[n].chinese>100){
                System.out.println("成绩必须在0-100之间");
            }
            System.out.println("请输入学生数学成绩:");
            s[n].math=In.nextDouble();
            if(s[n].math<0||s[n].math>100){
                System.out.println("成绩必须在0-100之间");
            }
            ++n;
            System.out.println();
            System.out.println("是否继续添加(Y/N)");
            str=In.next();
            ch=str.charAt(0);
            while(ch!='N'&&ch!='n'&&ch!='Y'&&ch!='y')
            {
                System.out.println("输入无效，请重新输入:");
                str=In.next();
                ch=str.charAt(0);
            }
            if(ch=='N'||ch=='n')
            {
                //创建全局变量 方便后面关闭流
                FileWriter fw=null;
                BufferedWriter bw=null;
                try {
                    //将学生信息录入指定的txt文件中
                    fw=new FileWriter(filePath,true);
                    bw=new BufferedWriter(fw);
                    for(int k=0;k<n;k++){
                        fw.write(s[k].num+"\t"+s[k].name+"\t"+s[k].classAge+"\t"+
                                s[k].chinese+"\t"+s[k].math+"\r\n");

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        //流关闭也会产生异常
                        bw.close();
                        fw.close();

                    }catch (IOException e){
                        e.printStackTrace();
                    }

                }
                System.out.println("写入成功");
                break;
            }
        }
        System.out.print("是否返回系统主菜单(Y/N)");
        str1=In.next();
        ch1=str1.charAt(0);
        while(ch1!='Y'&&ch1!='y'&&ch1!='N'&&ch1!='n')
        {
            System.out.println("输入无效，请重新输入:");
            str1=In.next();
            ch1=str1.charAt(0);
        }
        if(ch1=='Y'||ch1=='y')
        {
            this.menu();
        }
        if(ch1=='N'||ch1=='n')
        {
            System.out.println("");
            System.out.println("你已退出系统！！！");
            System.exit(0);
        }
    }

    //显示学生信息  
    public void show() throws IOException
    {
        int i;
        this.isStuExist();
        System.out.println("本次操作共录入"+n+"位学生!");
        System.out.println("你录入的学生信息如下:");
        System.out.println("学号\t姓名\t班级\t语文\t数学");//	英语
        for(i=0;i<n;i++)
        {
            //s[i].english
            System.out.println(s[i].num+"\t"+s[i].name+"\t"+s[i].classAge+"\t"+s[i].chinese+"\t"+s[i].math);
        }
        System.out.println("系统返回主菜单!");
        this.menu();
    }

    /**
     * 删除学生成绩信息
     * @throws IOException
     */
    public void delete() throws IOException
    {
        //判断是否有学生信息存在
        this.isStuExist();
        //从文件中读入赋值
        String student[][]=getStuInfoByFile(filePath);
        int j,t=0,k=0,num1;
        char ch;
        String str;
        Scanner pin=new Scanner(System.in);
        System.out.println("请输入要删除的学号:");
        num1=pin.nextInt();
        for(j=0;j<n;j++)
        {
            if(Integer.parseInt(student[j][0])==num1)
            {
                k=1;
                t=j;
            }
        }
        if(k==0)
        {
            System.out.println("对不起！你要删除的学号不存在！");
            System.out.println("系统将返回主菜单！");
            this.menu();
        }
        if(k==1)
        {
            System.out.println("你要删除的学生信息如下:");//打印管理员要删除的学生信息  
            System.out.println("学号\t姓名\t班级");//本功能暂时不备扩展性  
            System.out.println(student[t][0]+"\t"+student[t][1]+"\t"+student[t][2]);
            System.out.println("你确定要删除(Y/N):");
            str=pin.next();
            ch=str.charAt(0);
            while(ch!='Y'&&ch!='y'&&ch!='N'&&ch!='n')
            {
                System.out.println("输入无效，请重新输入:");
                str=pin.next();
                ch=str.charAt(0);
            }
            if(ch=='N'||ch=='n')
            {
                System.out.println();
                System.out.println("系统返回主菜单！");
                this.menu();
            }
            if(ch=='Y'||ch=='y')
            {
                for(j=t;j<n-1;j++)
                {
                    s[j]=s[j+1];
                }
                n--;
                System.out.println("学生数据成功删除!");
                //数据写回文件
                //其实不需要这么麻烦 读出 写入 可直接判断删除指定即可
                //根据需求封装函数
                System.out.println("系统返回主菜单!");
                this.menu();
            }
        }
    }

    /**
     * 查看学生成绩信息
     * @throws IOException
     */
    public void look() throws IOException
    {
        FileReader fr=new FileReader(filePath);  //查看txt中的学生信息
        int a;
        while((a=fr.read())!=-1)
        {
            System.out.print((char)a);
        }
        fr.close();
        System.out.println("系统返回主菜单！");
        this.menu();
    }

    /**
     * 修改学生成绩信息
     * @throws IOException
     */
    public void modify() throws IOException
    {
        this.isStuExist();
        //从文件中读入赋值
        String student[][]=getStuInfoByFile(filePath);
        int j=0,t=0,k=0,num2,num3,moi,c=1;
        char ch;
        String str,str1,str2;
        Scanner pin=new Scanner(System.in);
        System.out.println("请输入要修改的学号:");
        num2=pin.nextInt();
        for(j=0;j<n;j++)
        {
            if(s[j].num==num2)//Integer.parseInt(student[j][0])
            {
                k=1;
                t=j;
            }
        }
        if(k==0)
        {
            System.out.println("对不起！你要修改的学号不存在！");
            System.out.println("系统将返回主菜单！");
            this.menu();
        }
        if(k==1)
        {
            //打印将要要删除的学生信息  
            System.out.println("你要修改的学生信息如下:");
            System.out.println("学号\t姓名\t班级");
            System.out.println(student[t][0]+"\t"+student[t][1]+"\t"+student[t][2]);
            System.out.println("语文\t数学");//英语
            System.out.println(student[t][3]+"      "+student[t][4]);
            System.out.println();
            System.out.println("你确定要修改(Y/N):");
            str=pin.next();
            ch=str.charAt(0);
            while(ch!='Y'&&ch!='y'&&ch!='N'&&ch!='n')
            {
                System.out.println("输入无效，请重新输入:");
                str=pin.next();
                ch=str.charAt(0);
            }
            if(ch=='N'||ch=='n')
            {
                System.out.println();
                System.out.println("系统返回主菜单！");
                this.menu();
            }
            while(c==1)
            {
                if(ch=='Y'||ch=='y')
                {
                    System.out.println("****************************************");
                    System.out.println("*****         1.修改学号           *****");
                    System.out.println("*****         2.修改班级           *****");
                    System.out.println("*****         3.修改姓名           *****");
                    System.out.println("****************************************");
                    System.out.println("请选择:");
                    moi=pin.nextInt();
                    switch(moi)
                    {
                        case 1:
                        {
                            System.out.print("请输入新的学号:");
                            num3=pin.nextInt();
                            //s[t].num=new Integer(num3).toString(); //student[j][0]
                            s[t].num=num3;
                        }
                        break;
                        case 2:{
                            System.out.print("请输入新的班级:");
                            str1=pin.next();
                            s[t].classAge=str1;
                        }
                        break;
                        case 3:{
                            System.out.print("请输入新的姓名:");
                            str2=pin.next();
                            s[t].name=str2;
                        }
                        break;
                    }
                    System.out.println("数据已成功修改！");
                }
                System.out.print("是否继续修改(Y/N)");
                str=pin.next();
                ch=str.charAt(0);
                System.out.println();
                while(ch!='Y'&&ch!='y'&&ch!='N'&&ch!='n')
                {
                    System.out.print("输入无效，请重新输入:");
                    str=pin.next();
                    ch=str.charAt(0);
                }
                if(ch=='N'||ch=='n')
                {
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("系统返回主菜单！");
        this.menu();
    }

    /**
     * 冒泡排序
     * @param numbers
     * @return
     */
    public double[] bubbleSort(double[] numbers)
    {
        int size = numbers.length;
        for(int i = 0 ; i < size-1; i ++)
        {
            for(int j = 0 ;j < size-1-i ; j++)
            {
                if(numbers[j] > numbers[j+1])  //交换两数位置
                {
                    double temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        return numbers;
    }

    /**
     * 排序存入
     */
    public void saveSort() throws IOException{
        //1.读入学生信息并计算总分
        String [][]student=getStuInfoByFile(filePath);
        double []sumSorce =new double[5];//存入学生总成绩
        //2.声明存入文件
        FileWriter fw=null;
        try {
            //将学生信息录入指定的txt文件中
            File file=new File("D://sort.txt");
            if(file.exists())
                file.delete();
            fw=new FileWriter("D://sort.txt",true);
//            fw.write("统计后的信息\r\n学号\t姓名\t班级\t语文\t数学\t总成绩\r\n");
            for(int i=0;i<5;i++){
                sumSorce[i]=Double.parseDouble(student[i][3])+Double.parseDouble(student[i][4]);
//                fw.write(s[i].num+"\t"+s[i].name+"\t"+s[i].classAge+"\t"+s[i].chinese+"\t"+s[i].math+"\t"
//                        +(s[i].chinese+s[i].math));
            }
            //排序总分
            double sortSorce[]=bubbleSort(sumSorce);
            //循环写入
            for(int j=0;j<5;j++){
                fw.write(student[j][0]+"\t"+student[j][1]+"\t"+student[j][2]+"\t"+student[j][3]+"\t"
                +student[j][4]+"\t"+sortSorce[j]+"\r\n");
            }
            System.out.println("写入成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            fw.close();
        }

    }

    /**
     * 获取一个数值的百分比，可根据实际情况使用
     * @param number 数字
     * @param value 位数
     * @return
     */
    public String FormatPercent(double number,int value){

        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumIntegerDigits(value);
        return nf.format(number);
    }

    /**
     * 根据文件路径获取文件信息
     * @param filepath
     * @return 学生信息
     */
    public String[][] getStuInfoByFile(String filepath){

        //为避免用异形list，采用数组获取文件中的内容
        //学生基本信息 五名学生
        String [][]student=new String[5][5];
        int xline = 0;   // 用于统计行数，从0开始
        BufferedReader br=null;
        try {
            //读取文件
            br=new BufferedReader(new FileReader(filepath));
            String line;
            while ((line=br.readLine())!=null){
                //分割每一行的数据
                String[] vStrs = line.split("\t");
                //获取学生基本信息
                //获取学生的两门成绩 这种方法很不好拓展
                for(int i=0;i<vStrs.length;i++){
                    student[xline][i]=vStrs[i];
                }
                xline++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return student;
    }

    /**
     * 统计学生成绩信息
     */
    public void countSorce(){
        //声明变量存储
        int countG=0;//不及格人数 默认两科成绩均及格方能算
        int countY=0;//优 90
        int countN=0;//良 80
        //不及格人数=成绩差的人数=总人数-及格人数
        //从文件获取学生基本信息 五名学生
        String [][]student=getStuInfoByFile(filePath);
        double []avgSorce=new double[5];//平均分

        //xline 为文件的行数 实际上既是学生的实际人数，以上的n声明为最大的数目
        System.out.println(student.length);

        for(int i=0;i<5;i++){
                if(Double.parseDouble(student[i][3])>90&&Double.parseDouble(student[i][4])>90){
                    countY++;
                }
                if(Double.parseDouble(student[i][3])>80&&Double.parseDouble(student[i][4])>80){
                    countN++;
                }
                if(Double.parseDouble(student[i][3])<60&&Double.parseDouble(student[i][4])<60){
                    countG++;
                }

                avgSorce[i]=(Double.parseDouble(student[i][3])+Double.parseDouble(student[i][4]))/2;
        }
        //平均分
        System.out.println("各学生平均分如下：");
        for(int i=0;i<5;i++){
            System.out.println(student[i][0]+":"+avgSorce[i]);
        }
        System.out.println("及格比例\t不及格比例\t优/良/差比例\n");
        System.out.println(countG+"\t"+countN+"\t"+countY);
        //引用百分比函数 进行数值转换
        System.out.println(FormatPercent(1-countG/5.0,0)+"\t"+
                FormatPercent(countG/5.0,0)+"\t"+ FormatPercent(countY/5.0,0)+
                "/"+FormatPercent(countN/5.0,0)+"/"+ FormatPercent(countG/5.0,0));
    }
}

