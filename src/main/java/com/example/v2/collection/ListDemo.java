package com.example.v2.collection;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * List：有序，可重复
 * 1、位置访问
 * 2、查找
 * 3、迭代
 * 4、范围视图
 * <p>
 * 实现类：ArrayList、LinkedList
 */
public class ListDemo {
    public static void main(String[] args) {
        //List list = new ArrayList<>();
        Arrays.asList(new Person("a", 1), new Person("a", 2))
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList())
                .forEach(n -> System.out.println(n));
    }
}
