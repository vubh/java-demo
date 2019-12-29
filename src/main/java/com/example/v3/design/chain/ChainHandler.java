package com.example.v3.design.chain;



public abstract class ChainHandler {
    public void excute(Chain chain){
        handleProcess();
        chain.proceed();
    }
    protected abstract void handleProcess();
}
