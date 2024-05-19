package com.rainbowsea.spring6.test;

import com.rainbowsea.spring6.bean.User;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringJunit4Test2 {

    @Resource(name = "user")
    private User user;

    @Test
    public void testUser() {
        System.out.println(user.getName());
    }


    @Test
    public void testUser2() {
        System.out.println(user.getName());
    }

    @Test
    public void testUser3() {
        System.out.println(user.getName());
    }


}
