package com.rainbowsea.reflect.sprint.bean2;


import org.springframework.stereotype.Controller;

@Controller(value = "orderDao")
public interface OrderDao {

    void insert();
}
