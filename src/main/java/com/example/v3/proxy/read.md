## Spring主要有两大思想
1、IoC

2、AOP
* AOP的原理就是java的动态代理机制
* cglib原理是通过生成一个继承于真实类的字节码，重写真实类（父类）的方法

## jdk与cglib代理对比
* jdk只能对有接口的类的接口方法进行动态代理
* cglib基于继承来实现代理，无法对static、final类代理
* cglib基于继承来实现代理，无法对private、static方法代理

## SpringAop代理选择
* 目标对象实现了接口，则默认jdk代理
* 目标对象没有实现接口，则采用cglib代理
* 目标对象实现了接口，且强制cglib代理，则采用cglib代理