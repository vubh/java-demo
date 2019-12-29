package com.example.v3.design.observer.server;

import com.example.v3.design.observer.client.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 人民日报微信公众号
 */
public class RenmrbGongzh implements Subject {

    /**
     * 人民日报公众号订阅者们
     */
    private List<Observer> obs = null;

    public RenmrbGongzh(){
        this.obs = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        if(obs != null){
            obs.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        int index = obs.indexOf(o);
        if(index >= 0){
            obs.remove(index);
        }
    }

    @Override
    public void notifyObserver(String msg) {
        for (Observer o : obs
             ) {
            o.update(msg);
        }
    }

    public void product(){
        int i = 100;
       while (true){
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           notifyObserver(String.valueOf(i--));
       }
    }
}
