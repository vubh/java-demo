package com.example.v2.reflect;

/**
 * 实体类
 */
public class Book {

    //私有属性
    private final static String TAG = "BookTag";

    private String name;
    private String author;

    public Book() {
    }

    //私有构造方法
    private Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    //私有方法
    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "I am declaredMethod 1 !";
                break;
            case 1:
                string = "I am declaredMethod 2 !";
                break;
            default:
                string = "I am declaredMethod 1 !";
        }

        return string;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
