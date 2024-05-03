package com.rainbowsea.service;

import com.rainbowsea.dao.StudentDao;
import org.springframework.stereotype.Repository;


@Repository(value = "studentDaoImplForMySQL")
public class StudentDaoImplForMySQL implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL删除数据");
    }
}
