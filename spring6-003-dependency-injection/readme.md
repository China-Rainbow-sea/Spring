## IOC 控制反转
* **控制反转是一种思想**
* 控制反转是为了降低程序耦合读，提高程序扩展力，达到OCP原则，达到DIP原则
* 控制反转，反转的是什么：？
>  * 将对象的创建权利交出去，交给第三方容器负责
>  * 将对象和对象之间关系的维护权交出去，交给第三方容器负责
* 控制反转这种思想如何实现呢？
* DI(Dependency lnjection) : 依赖注入


## 依赖注入:
依赖注入实现了控制反转的思想：
**Spring通过依赖注入的方式来完成Bean管理的** 
**Bean管理说的是：Bean对象的创建，以及Bean对象中属性的赋值（或者叫做Bean对象之间关系的维护）

### 依赖注入:
* 依赖指的是对象和对象之间的关联关系：
* 注入指的是一种数据传递行为，通过注入行为来让对象和对象产生关系
**依赖注入常见的实现方式包括两种:** 
* **第一种: set 注入**
* **第二种：构造注入** 

**总结: set 注入的核心实现原理：通过反射机制实现调用 set 方法来给属性赋值，让两个对象之间产生关系。** 

## 构造注入：
**核心原理: 通过调用构造方法来给属性赋值** 

