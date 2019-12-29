package com.example.v3.list;

/**
 * 自定义List接口
 * @param <E>
 */
public interface MyList<E> {
     void add(E object);

     void add(int index, E object);

     Object remove(int index);

     boolean remove(E object);

     int getSize();

     Object get(int index);
}
