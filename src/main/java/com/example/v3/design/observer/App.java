package com.example.v3.design.observer;

import com.example.v3.design.observer.client.UserA;
import com.example.v3.design.observer.server.RenmrbGongzh;

public class App {
    public static void main(String[] args) {

        RenmrbGongzh r = new RenmrbGongzh();
        UserA a = new UserA  (r);

        r.product();
    }
}
