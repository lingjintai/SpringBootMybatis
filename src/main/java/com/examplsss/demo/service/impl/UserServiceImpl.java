package com.examplsss.demo.service.impl;

import com.examplsss.demo.dao.UserDao;
import com.examplsss.demo.entity.User;
import com.examplsss.demo.service.UserService;
import com.examplsss.demo.task.MyTask;
import com.examplsss.demo.task.threadPool.MyTaskThreadPool;
import com.examplsss.demo.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 11:08
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User Sel(int id, User user1) {
        UserDao bean = BeanUtil.getBean(UserDao.class);
        User user = new User();
        user.setId(1);
        user.setAge(12);
        user.setPassword("1231");
        user.setUsername("张三");
        return userDao.Sel(id);
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public List<User> listById(String id) {
        MyTask myTask =new MyTask();
        MyTaskThreadPool.LZ_PUSH_POOL.execute(myTask);
        return null;
    }
}
