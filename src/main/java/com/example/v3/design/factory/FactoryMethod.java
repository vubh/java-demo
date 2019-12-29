package com.example.v3.design.factory;

/**
 * 
 * 工厂方法模式
 * 场景：实现共同接口的多个类需要实例化时
 * 缺点：类的实例化依赖工厂类，拓展程序时，就得必须对工厂类进行修改，违背了开闭原则
 * 
 * @author  wbh
 * 
 */
//interface Sender
//{
//    public void Send();
//}
//
//// 类1
//class MailSender implements Sender
//{
//    @Override
//    public void Send()
//    {
//        System.out.println("发送邮件");
//    }
//}
//
//// 类2
//class SmsSender implements Sender
//{
//    @Override
//    public void Send()
//    {
//        System.out.println("发送短信");
//    }
//}

// 工厂类 1.普通工厂模式:建立一个工厂类，对实现了同一接口的一些类进行实例的创建
class SendFactory1
{
    public Sender produce(String type)
    {
        if ("mail".equals(type))
        {
            return new MailSender();
        }
        else if ("sms".equals(type))
        {
            return new SmsSender();
        }
        else
        {
            return null;
        }
    }
}

// 工厂类 2.多个工厂方法模式:提供多个工厂方法，分别创建对象
class SendFactory2
{
    public Sender produceMail()
    {
        return new MailSender();
    }

    public Sender produceSms()
    {
        return new SmsSender();
    }
}

// 工厂类 3.将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
class SendFactory3
{
    public static Sender produceMail()
    {
        return new MailSender();
    }

    public static Sender produceSms()
    {
        return new SmsSender();
    }
}

public class FactoryMethod
{
    public static void main(String[] args)
    {
        System.out.println("**************普通工厂模式***************");
        SendFactory1 factory1 = new SendFactory1();
        Sender sender1 = factory1.produce("mail");
        sender1.Send();
        Sender sender2 = factory1.produce("sms");
        sender2.Send();
        System.out.println("**************多个工厂方法模式***************");
        SendFactory2 factory2 = new SendFactory2();
        factory2.produceMail().Send();
        factory2.produceSms().Send();
        System.out.println("**************静态工厂方法模式***************");
        SendFactory3.produceMail().Send();
        SendFactory3.produceSms().Send();
    }
}
/*
 * 总结： 工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
 * 在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象， 第三种相对于第二种，不需要实例化工厂类，
 * 所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
 */
