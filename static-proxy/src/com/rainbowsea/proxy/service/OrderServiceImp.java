package com.rainbowsea.proxy.service;


/**
 * 项目经理提出一个新的需求，要统计所以业务接口中有一个业务方法的耗时
 * 解决方案一：硬编码，在每一个业务接口中的每一个业务方法中直接添加统计耗时的程序。
 * 这种方案的缺点：
 *      缺点一：违背了OCP开闭原则（修改关闭，这里修改（改了源代码），扩展打开）
 *      缺点二：代码没有得到复用（相同的代码写了很多遍）
 * 解决方案二：编写业务类的子类，让子类集成业务类，对每个业务方法进行编写
 *      缺点一：虽然解决了OCP开闭原则，但是这种方式会导致耦合度很高，因为采用了继承关系
 *      缺点二：代码没有得到复用（相同的代码写了很多遍）
 */
public class OrderServiceImp implements OrderService{  // 目标对象

    @Override
    public void generate() {

        // 模拟生成订单的耗时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("订单已生成");

    }

    @Override
    public void modify() {
        // 模拟生成订单的耗时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已修改");
    }

    @Override
    public void detail() {


        // 模拟生成订单的耗时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("请看订单详情");

    }
}
