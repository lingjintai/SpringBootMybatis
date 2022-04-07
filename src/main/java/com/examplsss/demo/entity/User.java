package com.examplsss.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 10:51
 */
@NoArgsConstructor
@Data
public class User {

    ///1111
    private int id;
    private String username;
    private String password;
    private int age;

    public static void main(String[] args) {

        System.out.println("111".split(",").length);

        List<User>  list = new ArrayList<>();

        User user = new User();
        user.setPassword(null);
        user.setUsername("111");

        list.add(user);



    }






}
