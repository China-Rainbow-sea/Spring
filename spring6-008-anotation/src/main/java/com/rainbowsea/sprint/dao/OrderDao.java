package com.rainbowsea.sprint.dao;


import org.springframework.stereotype.Controller;

@Controller(value = "orderDao")
public interface OrderDao {

    void insert();
}
