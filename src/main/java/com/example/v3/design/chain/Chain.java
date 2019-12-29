package com.example.v3.design.chain;


import java.util.List;

/**
 * 封装handler关系
 */
public class Chain {
    private List<ChainHandler> handlers;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    private int index = 0;

    public void proceed() {
        if (index >= handlers.size()) {
            return;
        }
        handlers.get(index++).excute(this);
    }
}
