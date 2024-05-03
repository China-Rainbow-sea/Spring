package com.rainbowsea.service;

import com.rainbowsea.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service(value = "studentService")
public class StudentService {

    //@Resource(name = "studentDaoImplForMySQL") 可以在属性上赋值
    private StudentDao studentDao;

    //@Resource(name = "studentDaoImplForMySQL")  不可以在构造方法上赋值
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Resource(name = "studentDaoImplForMySQL")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void deleteStudent() {
        studentDao.deleteById();
    }
}
