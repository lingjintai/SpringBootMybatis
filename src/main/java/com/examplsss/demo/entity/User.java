package com.examplsss.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 10:51
 */
@NoArgsConstructor
@Data
@Builder
public class User {

    ///11
    private int id;
    private String username;
    private String password;
    private int age;



}
