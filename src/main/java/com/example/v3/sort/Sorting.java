package com.example.v3.sort;

import java.util.Arrays;

/**
 * 排序及二分查找
 * 
 */
public class Sorting
{
    public static void main(String[] args)
    {        
        //选择排序
        sortOne(new int[]{24, 69, 80, 57, 13});
        System.out.println("=================");

        //冒泡排序
        sortTwo(new int[]{24, 69, 80, 57, 13});
        System.out.println("=================");
         
        //Arrays.sort(new int[]{24, 69, 80, 57, 13});
        
        //二分查找
        int index = getIndex(new int[]{13, 24, 57, 69, 80},57);
        System.out.println("元素位置："+index);
        
        //Arrays.binarySearch(new int[]{13, 24, 57, 69, 80},13);
    }

    /**
     * 选择排序
     * 总结：n个数排序，共比较n-1次
     */
    static void sortOne(int[] arr)
    {
        for (int i = 0; i < arr.length-1; i++)
        {
            int base = arr[i];
            for (int j = i+1; j <= arr.length-1; j++)
            {
                int tem = arr[j];
                if(tem < base)
                {
                    int m = arr[i];
                    arr[i] = arr[j];
                    arr[j] = m;
                }                
            }
            System.out.println("第"+(i+1)+"次排序后结果："+Arrays.toString(arr));
        }
        System.out.println("排序后结果:"+Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * 总结：n个数排序,共比较n-1轮，每m轮比较次数n-1-m
     */
    static void sortTwo(int[] arr)
    {
        for (int i = 0; i < arr.length-1; i++)
        {
            for (int j = 0; j < arr.length-1-i; j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int m = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = m;
                }
            }
            System.out.println("第"+(i+1)+"次排序后结果："+Arrays.toString(arr));
        }
        System.out.println("排序后结果:"+Arrays.toString(arr));
    }

    /**
     * 二分查找
     * 注意：1、必须有序数组 2、无序数组先排序再二分查找也不可以
     * 
     */
    static int getIndex(int[] arr,int value) {
        int max = arr.length-1;
        int min = 0;
        int mid = (max+min)/2;

        while(arr[mid] != value) {
            if(arr[mid] > value) {
                max = mid - 1;
            }else if(arr[mid] < value) {
                min = mid + 1;
            }

            if(max < min) {
                return -1;
            }

            mid = (max+min)/2;
        }
        return mid;
    }
}
