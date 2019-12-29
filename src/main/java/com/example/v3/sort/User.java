package com.example.v3.sort;

public class User implements Comparable<User>
{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 重写比较方法
     * @param other
     * @return
     */
    @Override
    public int compareTo(User other)
    {
        return Integer.compare(age, other.age);
    }
}
