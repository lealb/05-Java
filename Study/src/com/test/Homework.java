package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 * 随堂测试
 * Created by leal
 * on 17-3-16.
 */
public class Homework {

    public static void main(String[] args){

        //调用方法
        Homework homework=new Homework();
        int []b= homework.generateArray(10,20);
//        System.out.println(Arrays.toString(b));
//        homework.guessGame();

//        for (int i=1000;i<10000;i++){
//            int c[]=homework.splitNums(i);
//            if(c[0]<c[1]&&c[1]<c[2]&&c[2]<c[3]&&(c[0]+c[1]+c[2]==c[3])){
//                System.out.println(c[0]+c[1]*10+c[2]*100+c[3]*1000);
//            }
//        }

//        System.out.println( homework.getSqrtNums(15,37).toString());
//        homework.table();
        System.out.println(homework.getPrime(100));
        homework.Pyramid(5);
        homework.revNum(120);
        String string="I LOVE YOU";
        //new StringBuffer(string).reverse().toString()
        System.out.println(new StringBuilder(string).reverse().toString());
        System.out.println(homework.strReverseByArray(string));
    }

    /**
     * 获得指定长度和范围的随机数
     * @param length 数组长度
     * @param max 随机数范围
     * @return 数组
     */
    public int[] generateArray(int length,int max){
        //声明一个长度为Length的数组
        int a[]=new int[length];
        //得到随机数
        Random random=new Random();
        for(int i=0;i<length;i++){
            //方法1
//            a[i]=(int)(Math.random()*max);//0-(max-1)
            //方法2 Random
            a[i]=random.nextInt(max);//0-(max-1)
        }
        return a;
    }

    /**
     * 猜数游戏主方法
     */
    public void guessGame() {

        Scanner scanner = new Scanner(System.in);
        // 表示游戏等级，默认为5
        int level = 5;
        do {
            System.out.println("请输入游戏级别(5/7/9):");
            level = scanner.nextInt();
        } while (level != 5 && level != 7 && level != 9);
        char[] chs = generate(level);

        System.out.println(chs);
        int count = 0;
        System.out.println("开始猜吧!(EXIT退出)");
        while (true) {
            String str = scanner.next().toUpperCase();
            if (str.equals("EXIT")) {
                System.out.print("下次再来吧！");
                break;//也可跳出循环
            }
            char[] input = str.toCharArray();
            int[] result = check(chs, input);
            if (result[0] == chs.length) {
                int score = 100 * chs.length - 10 * count;
                System.out.println("恭喜你猜对了。得分为" + score);
                break;
            } else {
                count++;
                System.out.println("字符对" + result[1] + "个,位置对" + result[0] + "个");
            }
        }
    }

    /**
     * 检查字符是否相等
     * @param chs 随机生成的字符数组
     * @param input 用户输入的字符数组
     * @return
     */
    public int[] check(char[] chs, char[] input) {

        int[] result = new int[2];
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (chs[i] == input[j]) {
                    result[1]++;//字符数相等
                    if (i == j) {
                        result[0]++;//字符数&字符位置相等
                    }
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 随机获得字符串
     * 采用布尔数据值存储，存在改变其值（保证获得随机数不重复）
     * @return
     */
    public char[] generate(int length) {
        char[] chs = new char[length];
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};//26字符
        boolean[] flags = new boolean[letters.length];
        for (int i = 0; i < chs.length; i++) {
            int index;
            do {
                //celiing floor 取整方法也可实现 Random类
                index = (int) (Math.random() * letters.length);
            } while (flags[index]);
            chs[i] = letters[index];
            flags[index] = true;
        }
        return chs;
    }

    /**
     * 四位数分割
     * @param nums
     * @return
     */
    public int[] splitNums(int nums){

        //定义一个存储千百十个位的整形数组
        int [] splitNums=new int[4];
        //四次循环实现依次取出个十佰仟位
        for (int i=0;i<splitNums.length&&nums>0;i++ ){
            //i=0 第一步取出各位
            splitNums[i]=nums%10;
            //i=0 第一次除以10取整表示去掉个位
            nums/=10;
        }
       return splitNums;
    }

    /**
     * 利用恒等式1+3+5+7+....+(2*n-1)=n^2判断
     * @param n
     * @return
     */
    public boolean isSqrt(int n)
    {
        for(int i=1;n>0;i+=2) n-=i;
        return 0 == n;
    }

    /**
     * 获得两个数之间的完全平方数
     * @param min
     * @param max
     * @return
     */
    public List getSqrtNums(int min, int max){

        List<Integer> SqrtNums=new ArrayList<>();
        //int SqrtNums[];
        for (int i=min;i<=max;i++){
            if((int)(Math.sqrt(i))*(int)(Math.sqrt(i))==i){
                SqrtNums.add(i);
            }
        }
        return SqrtNums;
    }

    /**
     * 通过更改第二重循环的
     * 条件可展现各种形式
     */
    public void table(){
        for(int i=0;i<=9;i++){
            for(int j=9;j>=i;j--){
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println();
        }
    }

    /**
     * 获得指定范围的素数
     * @param max
     * @return
     */
    public List getPrime(int max){

        List<Integer> numsList=new ArrayList<>();
        for (int i=3;i<=max;i+=2){
            boolean flag=true;
            for (int j=3;j<= Math.sqrt(i);j++){
                if(i%j==0){
                    flag= false;
                    break;
                }
            }
            if(flag){
                numsList.add(i);
            }
        }
        return numsList;
    }

    /**
     * 2*i-1
     * 移位打出杨辉三角
     * @param num
     */
    public void Pyramid(int num) {

        for (int k = 0; k < num; k++) {
            for (int s = 0; s < num - k; s++) {
                System.out.print("  ");
            }
            for (int i = 0; i < k; i++) {
                System.out.print((1 << i) + " ");
            }
            for (int j = 0; j < k + 1; j++) {
                System.out.print(((1 << k) >> j) + " ");
            }
            System.out.println();
        }
    }

    /**
     * 反转数字
     * @param num
     */
    public void revNum(int num){
        while(num>0){
            if(num%10!=0){
                System.out.print(num%10);
            }
            num/=10;
        }
    }

    /**
     * 反转字符串通过数组
     * @param string
     * @return
     */
    public  String strReverseByArray(String string){
        if(string==null||string.length()==0)return string;
        int length = string.length();
        char [] array = string.toCharArray();
        for(int i = 0;i<length/2;i++){
            array[i] = string.charAt(length-1-i);
            array[length-1-i] = string.charAt(i);
        }
        return new String(array);
    }

    /**
     * 运用栈有"后进先出(LIFO)
     * @param string
     * @return
     */
    public String strReverseByStack(String string){
        if(string==null||string.length()==0)return string;
        Stack<Character> stringStack = new Stack<>();
        char [] array = string.toCharArray();
        for(Character c:array){
            stringStack.push(c);
        }
        int length = string.length();
        for(int i= 0;i<length;i++){
            array[i] = stringStack.pop();
        }
        return new String(array);
    }

    /**
     * 逆序输出
     * @param string
     * @return
     */
    public String strReverseByReverseLoop(String string){
        if(string==null||string.length()==0)return string;
        StringBuilder sb = new StringBuilder();
        for(int i = string.length()-1;i>=0;i--){
            sb.append(string.charAt(i));
        }
        return sb.toString();
    }

    /**
     *  两个数异或的结果再与其中一个数异或的结果是另外一个数
     这涉及到了离散数学中的异或的性质:
     1.交换律:A^B=B^A
     2.结合律: A^(B^C)=(A^B)^C
     3.恒等律:X^0=0
     4.归零律:X^X=0
     5.自反：A^B^B = A^0=A
     根据以上性质:
     A=A^B
     B=A^B
     A=A^B
     * @param string
     * @return
     */
    public static String strReverseByXor(String string){
        if(string==null||string.length()==0)return string;
        char [] array =string.toCharArray();
        int length = string.length()-1;
        for(int i =0;i<length;i++,length--){
            array[i]^=array[length];
            array[length]^=array[i];
            array[i]^=array[length];
        }
        return new String(array);
    }
}
