package com.rainbowsea.spring6.service.imp;

import com.rainbowsea.spring6.dao.UserDao;
import com.rainbowsea.spring6.dao.imp.UserDaoImplForMySQL;
import com.rainbowsea.spring6.service.UserService;

public class UserServiceImp implements UserService {

    private UserDao userDao = new UserDaoImplForMySQL();

    @Override
    public void deleteUser() {
        userDao.deleteById();
    }
}
