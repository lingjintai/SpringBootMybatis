package com.examplsss.demo.service;

import com.examplsss.demo.entity.User;

import java.util.List;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 11:08
 */
public interface UserService {

    User Sel(int id, User user);

    List<User> list();

    List<User> listById(String id);

}
