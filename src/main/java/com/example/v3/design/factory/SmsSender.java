package com.example.v3.design.factory;

/**
 * 短信发送
 */
public class SmsSender implements Sender
{
    @Override
    public void Send()
    {
        System.out.println("发送短信");
    }
}
