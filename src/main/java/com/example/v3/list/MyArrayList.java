package com.example.v3.list;

import java.util.Arrays;

/**
 * 手写ArrayList
 * @param <E>
 */
public class MyArrayList<E> implements MyList<E>{

    // 保存ArrayList中数据的数组
    private transient Object[] elementData;

    // 默认数组容量
    private static final int DEFAULT_CAPACITY = 10;

    // ArrayList实际数量
    private int size;

    // 默认初始化容量为10;
    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }
    E elementData(int index) {
        return (E) elementData[index];
    }
    // ArrayList 指定 数组初始的容量
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("初始容量不能小于0");
        }
        elementData = new Object[initialCapacity];
    }

    @Override
    public void add(E object) {
        // 1.判断实际存放的数据容量是否大于elementData容量
        ensureExplicitCapacity(size + 1);
        // 2.使用下标进行赋值
        elementData[size++] = object;
    }

    @Override
    public void add(int index, E object) {
        rangeCheck(index);
        // 1.判断实际存放的数据容量是否大于elementData容量
        ensureExplicitCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = object;
        size++;
    }

    // int minCapacity 最当前size+1
    public void ensureExplicitCapacity(int minCapacity) {
        // 如果存入的数据,超出了默认数组初始容量 就开始实现扩容
        if (size == elementData.length) {
            // 获取原来数组的长度 2
            int oldCapacity = elementData.length;
            // oldCapacity >> 1 理解成 oldCapacity/2 新数组的长度是原来长度1.5倍
            // 新数据容量大小 (oldCapacity >> 1)=oldCapacity/
            int newCapacity = oldCapacity + (oldCapacity >> 1); // 3
            // 如果初始容量为1的时候,那么他扩容的大小为多少呢？
            if (newCapacity < minCapacity) {
                // 最小容量比新容量要小的,则采用初始容量minCapacity
                newCapacity = minCapacity;
            }
            // 将老数组的值赋值到新数组里面去
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }


    @Override
    public Object remove(int index) {
        // 1.使用下标查询该值是否存在
        Object object = get(index);
        int numMoved = elementData.length - index - 1;
        // 2.删除原理 使用arraycopy往前移动数据,将最后一个变为空
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;// 将最后一个元素变为空
        return object;
    }

    @Override
    public boolean remove(E object) {
        for (int i = 0; i < elementData.length; i++) {
            Object element = elementData[i];
            if (element.equals(object)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("数组越界啦!");
        }
    }
}
