package com.example.v3.design.observer.client;

import com.example.v3.design.observer.server.RenmrbGongzh;

/**
 * 订阅者
 */
public class UserA implements Observer {

    public UserA(RenmrbGongzh r) {
        r.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("发布==" + msg + "==文章");
    }
}
