package com.example.v3.list;

import java.util.Arrays;


/**
 * 怎么保证集合存放无限大小---数组扩容技术
 */
public class ReadMe {

    public static void main(String[] args) {
        growFun();
    }

    public static void growFun() {
        Object[] objects = {1, 2};
        System.out.println(objects.length);
        Object[] copyNewObjects = Arrays.copyOf(objects, 10);
        System.out.println(copyNewObjects.length);


        // 参数src 原数组 srcPos 其实位置 dest 目标数组 destPos 目标起始位置 length 复制长度
        int[] fun = {0, 1, 2, 3, 4, 5, 6};
        System.arraycopy(fun, 3, fun, 0, 4);
        // 3456456
        for (int i : fun) {
            System.out.print(i);
        }

    }

}

