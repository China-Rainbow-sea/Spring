package com.rainbowsea.spring6.client;

import com.rainbowsea.spring6.dao.imp.UserDaoImpForOracle;
import com.rainbowsea.spring6.service.UserService;
import com.rainbowsea.spring6.service.imp.UserServiceImp;

public class Test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImp();
        // UserService userService = new UserServiceImp();
        userService.deleteUser();

    }
}
