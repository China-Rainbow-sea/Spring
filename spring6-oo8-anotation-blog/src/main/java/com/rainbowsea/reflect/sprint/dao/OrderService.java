package com.rainbowsea.reflect.sprint.dao;



import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "orderService")
public class OrderService {

    private OrderDao orderDao ;

    @Resource(name = "orderDaoImplForOracle")
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate() {
        orderDao.insert();
    }

}
