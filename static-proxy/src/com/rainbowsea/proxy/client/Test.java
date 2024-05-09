package com.rainbowsea.proxy.client;

import com.rainbowsea.proxy.service.OrderService;
import com.rainbowsea.proxy.service.OrderServiceImp;
import com.rainbowsea.proxy.service.OrderServiceImpSub;
import com.rainbowsea.proxy.service.OrderServiceProxy;

public class Test {


    /**
     * 解决方案三：代理模式
     * 目前我们使用的是静态代理，这个静态代理的缺点是什么？
     * 类爆炸，假设系统中i给你有1000个接口，那么每个接口都需要对于代理类，这样类会急剧膨胀，不好维护
     * 怎么解决类爆炸问题？
     *  可以使用动态代理来解决这个问题。
     *  动态代理是代理模式，只不过添加了字节码生成技术，可以在内存中为我们动态的生成一个class字节码，
     *  这个字节码就是代理类。
     *  在内存动态的生成字节码代理类的技术。叫做：动态代理
     * @param age
     */
    public static void main(String[] age) {
        // 创建目标对象
        OrderService target = new OrderServiceImp();
        // 创建代理对象
        OrderService proxy = new OrderServiceProxy(target);
        // 调用代理对象的代理方法

        proxy.generate();
        proxy.modify();
        proxy.detail();

    }


    /*
     * 解决方案二：编写业务类的子类，让子类集成业务类，对每个业务方法进行编写
     *      缺点一：虽然解决了OCP开闭原则，但是这种方式会导致耦合度很高，因为采用了继承关系
     *      缺点二：代码没有得到复用（相同的代码写了很多遍）
     */
    public static void main2(String[] age) {
        OrderService orderService = new OrderServiceImpSub();
        orderService.generate();

        orderService.detail();

        orderService.modify();
    }


    /*
    项目经理提出一个新的需求，要统计所以业务接口中有一个业务方法的耗时
 * 解决方案一：硬编码，在每一个业务接口中的每一个业务方法中直接添加统计耗时的程序。
 * 这种方案的缺点：
 *      缺点一：违背了OCP开闭原则（修改关闭，这里修改（改了源代码），扩展打开）
 *      缺点二：代码没有得到复用（相同的代码写了很多遍）
     */
    public static void main1(String[] age) {
        OrderService orderService = new OrderServiceImp();
        orderService.generate();

        orderService.detail();

        orderService.modify();
    }




}
