package com.example.v2.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 总结：
 * 带有Declared修饰的方法可以反射到私有的方法，没有Declared修饰的只能用来反射公有的方法。
 * 访问、调用私有需设置field.setAccessible(true);
 */
public class ReflectClass {

    public static void main(String[] args) throws Exception {
        ReflectClass.reflectNewInstance();
        ReflectClass.reflectPrivateConstructor();
        ReflectClass.reflectPrivateField();
        ReflectClass.reflectPrivateMethod();
    }

    // 创建对象
    public static void reflectNewInstance() throws Exception {
        Class<?> classBook = Class.forName("com.example.v2.reflect.Book");
        Object objectBook = classBook.newInstance();
        Book book = (Book) objectBook;
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        System.out.println("reflectNewInstance book = " + book.toString());
    }

    // 反射调用私有属性
    public static void reflectPrivateField() throws Exception {
        Class<?> classBook = Class.forName("com.example.v2.reflect.Book");
        Object objectBook = classBook.newInstance();
        Field field = classBook.getDeclaredField("TAG");
        field.setAccessible(true);
        String tag = (String) field.get(objectBook);
        System.out.println("reflectPrivateField book = " + tag);
    }

    // 反射调用私有构造方法
    public static void reflectPrivateConstructor() throws Exception {
        Class<?> classBook = Class.forName("com.example.v2.reflect.Book");
        Constructor<?> constructor = classBook.getDeclaredConstructor(String.class, String.class);
        constructor.setAccessible(true);
        Book book = (Book) constructor.newInstance("三国演义", "罗贯中");
        System.out.println("reflectPrivateConstructor book = " + book.toString());
    }

    // 反射调用私有构造方法
    public static void reflectPrivateMethod() throws Exception {
        Class<?> classBook = Class.forName("com.example.v2.reflect.Book");
        Object objectBook = classBook.newInstance();
        Method method = classBook.getDeclaredMethod("declaredMethod", int.class);
        method.setAccessible(true);
        Object object = method.invoke(objectBook, 1);
        System.out.println("reflectPrivateMethod book = " + object.toString());
    }
}
