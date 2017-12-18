package com.test;

import java.util.Arrays;

/**
 * Description:排序探讨
 * 排序均基于内部排序(内存排序)
 * Version:v1.0
 * Created by Leal
 * on 2017/6/13:17:51.
 */
public class SortAnalyze {
    /**
     * 测试主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        SortAnalyze sortAnalyze = new SortAnalyze();
        int[] a = new int[]{20, 13, 16, 1, 45, 32, 45, 75, 21, 10};
        System.out.println(Arrays.toString(sortAnalyze.BubbleSort(a)));
        //System.out.println(Arrays.toString(sortAnalyze.QuickSort(a,0,9)));
        System.out.println(Arrays.toString(sortAnalyze.InsertSort(a)));
        System.out.println(Arrays.toString(sortAnalyze.ShellSort(a)));
        System.out.println(Arrays.toString(sortAnalyze.SelectSort(a)));

    }

    /**
     * 交换排序：冒泡
     * 稳定 相互比较(不跳跃) 时间：均为O(n^2) 空间：O(1)
     *
     * @param a
     * @return
     */
    public int[] BubbleSort(int[] a) {
        boolean flag;//是否交换的标志
        for (int i = 0; i < a.length - 1; i++) { //冒泡次数
            flag = false;
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;//本轮排序没有交换 改进后时间复杂度O(n) 正序的时候
        }
        return a;
    }

    /**
     * 冒泡：快速排序 分治思想
     * 不稳定 时间：平均/最好 O(nlogn) 最坏 (基本有序，退化成冒泡) 空间：O(nlogn)
     *
     * @param a 待排数组
     * @param l left
     * @param r right
     */
    public int[] QuickSort(int a[], int l, int r) {
        if (l >= r)
            return a;

        int i = l;
        int j = r;
        int key = a[l];//选择第一个数为key

        while (i < j) {
            //从右向左找第一个小于key的值
            while (i < j && a[j] >= key) {
                j--;
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }
            }
            //从左向右找第一个大于key的值
            while (i < j && a[i] < key) {
                i++;
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
            }
        }
        //i == j
        a[i] = key;
        QuickSort(a, l, i - 1);//左边递归
        QuickSort(a, i + 1, r);//右边递归
        return a;
    }

    /**
     * 插入排序
     * 稳定 平均/最坏(逆序)O(n^2) 最好<顺序></>O(n) 空间：O(1)
     * @param a
     * @return
     */
    public int[] InsertSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {      //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
                int j = i - 1;
                int x = a[i];           //复制为哨兵，即存储待排序元素
                a[i] = a[i - 1];        //先后移一个元素
                while (x < a[j]) {      //查找在有序表的插入位置
                    a[j + 1] = a[j];
                    j--;                //元素后移
                }
                a[j + 1] = x;           //插入到正确位置
            }
        }
        return a;
    }

    /**
     * 插入：希尔排序
     * 根据增量分解为若干个序列，每个序列使用插入排序
     * 不稳定 时间：O(nlogn) 空间：O(1)
     * @param a
     * @return
     */
    public  int[] ShellSort(int a[]){

        int temp = 0;
        int dk = a.length;//增量
        while(true){
            dk = dk/2;
            for(int k = 0;k<dk;k++){    //根据增量分为若干子序列
                for(int i=k+dk;i<a.length;i+=dk){
                    for(int j=i;j>k;j-=dk){
                        if(a[j]<a[j-dk]){
                            temp = a[j-dk];
                            a[j-dk] = a[j];
                            a[j] = temp;
                        }else{
                            break;
                        }
                    }
                }
            }
            if(dk == 1)break;
        }
        return a;
    }

    /**
     * 选择排序：不断从序列中选取最小值与之比较 交换 改进成堆排序
     * 不稳定 O(n^2)
     * @param a
     * @return
     */
    public int[] SelectSort(int a[]){

        for(int i=0;i<a.length-1;i++){

            //查找最小值
            int minIndex = i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[minIndex]){
                    minIndex = j;
                }
            }
            //交换
            if(minIndex != i){
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        return a;
    }

    /**
     * 构建堆
     * @param array 待排数组
     */
    public void buildheap(int array[]){
        int length = array.length;
        int heapsize = length;
        int nonleaf = length / 2 - 1;
        for(int i = nonleaf; i>=0;i--){
            heapify(array,i,heapsize);
        }
    }

    /**
     *
     * @param array
     * @param i
     * @param heapsize
     */
    public void heapify(int array[], int i,int heapsize){
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<heapsize){
            if(array[i]>array[left]){
                smallest = left;
            }
            else smallest = i;
        }
        if(right<heapsize){
            if(array[smallest]>array[right]){
                smallest = right;
            }
        }
        if(smallest != i){
            int temp;
            temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;
            heapify(array,smallest,heapsize);
        }
    }

    /**
     * 堆排序 构建成大/小顶堆
     * 不稳定 时间:O(nlogn) 空间：O(1)
     * @param a
     * @return
     */
    public int[] HeapSort(int a[]){
        int heapsize = a.length;
        buildheap(a);

        for(int i=0;i<a.length-1;i++){
            // swap the first and the last
            int temp;
            temp = a[0];
            a[0] = a[heapsize-1];
            a[heapsize-1] = temp;
            // heapify the array
            heapsize = heapsize - 1;
            heapify(a,0,heapsize);

        }
        return a;
    }




}

