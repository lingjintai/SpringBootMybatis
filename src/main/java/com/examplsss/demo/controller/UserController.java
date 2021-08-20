package com.examplsss.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.examplsss.demo.advice.Handler;
import com.examplsss.demo.advice.MyLogger;
import com.examplsss.demo.annotation.Operate;
import com.examplsss.demo.entity.User;
import com.examplsss.demo.service.UserService;
import com.examplsss.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 11:02
 */
@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getUser/{id}")
    public JSONObject GetUser(@PathVariable int id) {
        JSONObject jsonObject = new JSONObject();
        UserService target = new UserServiceImpl();
        System.out.println(userService == target);
        System.out.println(userService);
        Handler handler = new Handler(userService, new MyLogger());
        UserService proxy = (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        System.out.println(proxy.getClass());
        User sel = proxy.Sel(id);
        jsonObject.put("sel", sel);
        return jsonObject;
    }


    @Operate(desc = "操作日志",type = "查询list")
    @GetMapping("/user/list")
    public JSONObject list() {
        JSONObject jsonObject = new JSONObject();
        List<User> list = userService.list();
        jsonObject.put("list",list);
        return jsonObject;
    }

    @Operate(desc = "操作日志",type = "根据id查询list")
    @GetMapping("/user/listById")
    public JSONObject listById(String id) {
        JSONObject jsonObject = new JSONObject();
        List<User> list = userService.listById(id);
        jsonObject.put("list",list);
        return jsonObject;
    }

}
