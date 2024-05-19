package com.rainbowsea.spring6.test;


import com.rainbowsea.spring6.bean.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringJunit5Test {

    @Resource(name = "user")  // 非简单类型的注入，赋值，交给Spring管理
    private User user;


    @Test  // import org.junit.jupiter.api.Test;
    public void testUser() {
        System.out.println(user.getName());
    }


    @Test  // import org.junit.jupiter.api.Test;
    public void testUser2() {
        System.out.println(user.getName());
    }

    @Test  // import org.junit.jupiter.api.Test;
    public void testUser3() {
        System.out.println(user.getName());
    }



}
