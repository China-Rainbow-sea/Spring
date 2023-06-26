## DCP 
 **什么是DCP** 
> DCP 是软件七大开发原则当中最基本的一个原则，开闭原则:
> 对什么开： 对扩展开放
> 对什么闭: 对修改关闭
> **DCP原则是最核心的，最基本的，其他的六个原则都是为这个原则服务的** 

**DCP的开闭原则的核心是什么：**
> 只要你在扩展系统功能的时候，没有修改以前的写好的代码，那么你就是符合DCP原则的
> 反之，如果在扩展系统功能的时候，你修改了之前的代码，那么这个设计是失败的，违背DCP开闭原则
> 当进行系统功能的扩展的时候，如果动了之前的稳定的程序，修改了之前的程序，之前所有程序都需要进行重新测试
> ，这是不想看到的，因为非常的麻烦。

## 依赖倒置原则(DIP原则)
![img.png](index/img.png)
> UserAction依赖级具体的UserServiceImpl
> UserServiceImpl 依赖了具体的UserDaoImplForMySQL
~~~~java

public class Test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImp();
        // UserService userService = new UserServiceImp();
        userService.deleteUser();

    }
}

public class UserServiceImp implements UserService {

    private UserDao userDao = new UserDaoImplForMySQL();

    @Override
    public void deleteUser() {
        userDao.deleteById();
    }
}

public class UserDaoImplForMySQL implements UserDao {

    @Override
    public void deleteById() {
        System.out.println("MySQL数据库正在删除数据");
    }
}



~~~~

> 目前来说：上是依赖下的：
> 凡是上依赖下，都违背了依赖倒置原则。
> 什么叫做符合依赖倒置原则，什么叫做遵守依赖倒置原则？
> 上不再依赖下了，表示符合倒置原则

**依赖倒置原则的核心是：倡导面向接口编程，面向抽象编程，不要面向具体编程** 
**依赖倒置原则的目的：** 
> 降低程序的耦合度，提高扩展力
> 什么叫做违背倒置原则:
> 上 依赖 下 ，就是违背了
> 只要“下”一改动吗，“上”就受到牵连

当前程序的设计，显然既违背OCP开闭原则，有违背了DIP，怎么办：
可以采用“控制反转”就这种编程思想来解决这个问题：


## 什么是控制反转：
> 反转是什么呢 ？
> 反转的是两件事：
>   > 第一件事：我不在程序中采用编码的方式 new 对象了，(new 对象我不管了，new 对象的权利交出去了)
>   > 第二件事：我不在程序中采用硬编码的方式来维护对象的关系了(对象之间关系的维护，我也不管了，交出去了。)

**控制反转: 是一种编程思想，或者叫做一种新型的设计模式，由于出现的比较新，没有背纳入到GOF23种设计模式范围内.
由于出现的比较新，没有被纳入GOF23种设计模式范围内。**


Spring 框架:
* Spring 框架实现了控制反转半帮你 new 对象
* Spring 框架可以帮你维护对象和对象之间的关系:
* Spring 是一个实现了IOC的思想的容器:
  * 控制反转的实现方式有多种: 其中比较重要的问题，：依赖注入 Dependency Injection 简称 BID
  * 控制反转是思想，依赖注入是这种思想的具体实现
  * 依赖注入DI，又包括常见的两种方式:
  * 第一种：set注入 (执行set 方法给属性赋值)
  * 第二种:构造方法注入(执行构造方法的属性赋值)
  
**依赖注入 中 “依赖” 是什么意思， “注入”是什么意思** 
> 依赖： A 对象和B对象的关系：
> 注入:是一种手段，通过这种手段，可以让A对象和B对象产生关系。
> 依赖注入：对象A和对对象B之间的关系，即靠注入的手段来维护，而注入包括: set注入和构造注入

**注意术语:** 
* OCP 开闭原则(开发原则)
* DIP 依赖倒置原则(开发原则)
* IOC 控制反转(一种思想，一种新型的设计模式)
* DI 依赖注入(控制反转的思想的具体实现方式)

> 什么是侵入式设计？
> 假设我开发了一个框架，这个框架中有一个类，类中一个方法
> ，该方法上有一个参数 HttpServlet 
> 框架中的某一个类:
~~~java
public class MyClass {
    public void doSome(HttpServet servlet ) {
        
    }
    
    public void doOther(HttpServerRequest request) {
        
    }
}
~~~

Bean 就是一个一个的豆子:

