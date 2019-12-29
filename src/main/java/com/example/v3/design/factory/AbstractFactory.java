package com.example.v3.design.factory;

/**
 * 
 * 抽象工厂
 * 场景：实现共同接口的多个类需要实例化时
 * 优点：解决工厂方法模式扩展程序时对工厂类的修改，
 * 方式：创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了
 * @author  wbh
 * 
 */
interface Provider
{
    public Sender produce();
}

// 工厂1
class SendMailFactory implements Provider
{
    @Override
    public Sender produce()
    {
        return new MailSender();
    }
}

// 工厂2
class SendSmsFactory implements Provider
{
    @Override
    public Sender produce()
    {
        return new SmsSender();
    }
}

public class AbstractFactory
{
    public static void main(String[] args)
    {
        Provider provider1 = new SendMailFactory();
        Sender sender1 = provider1.produce();
        sender1.Send();
        Provider provider2 = new SendSmsFactory();
        Sender sender2 = provider2.produce();
        sender2.Send();
    }
}

/*总结： 添加新的功能时，实现Sender接口，Provider接口*/
