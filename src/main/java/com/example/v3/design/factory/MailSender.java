package com.example.v3.design.factory;


/**
 * 邮件发送
 */
public class MailSender  implements Sender
{
    @Override
    public void Send()
    {
        System.out.println("发送邮件");
    }
}