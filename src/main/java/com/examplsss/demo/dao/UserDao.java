package com.examplsss.demo.dao;

import com.examplsss.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 11:05
 */
@Repository
public interface UserDao {


    User Sel(int id);

    List<User> list();


    List<User> listById(String id);

}
