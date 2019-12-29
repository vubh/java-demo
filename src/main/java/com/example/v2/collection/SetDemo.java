package com.example.v2.collection;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Set: 不重复的元素,无序
 *
 * LinkedHashSet: 有序
 */
public class SetDemo {
    public static void main(String[] args) {
        Arrays.asList(1, 1, 1)
                .stream()
                .collect(Collectors.toSet())
                .forEach(n -> System.out.println(n));

        Arrays.asList(new Person("a", 1), new Person("a", 2))
                .stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new))
                .forEach(n -> System.out.println(n));


    }
}
