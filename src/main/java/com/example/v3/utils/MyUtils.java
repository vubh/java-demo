package com.example.v3.utils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 我的工具类
 */
public class MyUtils {

    /**
     * 创建数组
     *
     * @param values
     * @param <T>
     * @return
     */
    public static <T> T[] of(T... values) {
        return values;
    }


    /**
     * 二维数组转Map
     *
     * @param vals
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> asMap(T[][] vals) {
        Map<String, T> mp = new LinkedHashMap<String, T>();
        if (vals != null && vals.length > 0) {
            for (int i = 0; i < vals.length; i++) {
                T[] objects = vals[i];
                if (objects != null && objects.length > 0) {
                    T k = objects[0];
                    T v = objects.length == 2 ? objects[1] : null;
                    mp.put(k.toString(), v);
                }
            }
        }
        return mp;
    }

    public static void main(String[] args) {

        Integer[] v1 = MyUtils.of(1, 2, 3);
        String[] v2 = MyUtils.of("a", "b", "c");
        System.out.println("Integer类型数组：" + Arrays.toString(v1));
        System.out.println("String类型数组：" + Arrays.toString(v2));


        Map<String, Object> map = MyUtils.asMap(new Object[][]{
                {"a", "value_a"},
                {"b", 1}
        });
        System.out.println("二维数组转map:" + map.toString());
    }
}
