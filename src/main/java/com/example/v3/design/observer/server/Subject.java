package com.example.v3.design.observer.server;

import com.example.v3.design.observer.client.Observer;

/**
 * 主题抽象接口
 */
public interface Subject {
    /**
     * 注册观察者
     */
    void registerObserver(Observer o);

    /**
     * 删除观察者
     */
    void removeObserver(Observer o);


    /**
     * 通知观察者
     */
    void notifyObserver(String msg);
}
