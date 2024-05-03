package com.rainbowsea.sprint.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "orderService")
public class OrderService {

    //  @Autowired 注解使用的时候，不需要指定任何属性，直接使用整个注解即可
    // 这个注解的作用是根据类型buType 进行自动装配
    //@Autowired
    // 当存在一个起义的时候，配合用上  @Qualifier 注解指明是哪个
    //@Autowired
    //@Qualifier联合使用，可以根据名字进行装配
    //@Qualifier(value = "orderDaoImplForOracle")
    private OrderDao orderDao ;


    // @Autowired 可以运用在构造方法上进行装配
    //public OrderService(@Autowired OrderDao orderDao) {
    //    this.orderDao = orderDao;
    //}


    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate() {
        orderDao.insert();
    }

}
