package com.example.v1.number;


/**
 * Integer源码中有个IntegerCache的内部类，类中一个数组，在静态代码块中初始化了-128-127的值
 *
 * Integer.valueOf()和new Integer()区别
 * 看源码，Integer.valueOf()首先判断值是否在[-128,127]之间
 * 是：从缓存中获取，多次调用时 == 为true
 * 否：调用new Integer()方法创建对象， 多次调用 == 为false
 */
public class IntegerTest {
    static final String x ="abc";
    static final String y ="abc";

    public static void main(String[] args) {
        /*Integer a = Integer.valueOf(127);
        Integer b = Integer.valueOf(127);
        System.out.println(a==b);

        Integer c = Integer.valueOf(128);
        Integer d = Integer.valueOf(128);
        System.out.println(c==d);


        System.out.println(Integer.valueOf(10)==Integer.valueOf(10));
        System.out.println(Integer.valueOf(130)==Integer.valueOf(130));


        System.out.println(x==y);*/

        String str1 = new String("1");
        String str2 = "1";
        str2.intern();
        System.out.println(str1==str2);



    }
}
