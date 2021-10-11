package com.examplsss.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.examplsss.demo.advice.Handler;
import com.examplsss.demo.advice.MyLogger;
import com.examplsss.demo.annotation.Operate;
import com.examplsss.demo.entity.DTO.TestExcelDTO;
import com.examplsss.demo.entity.User;
import com.examplsss.demo.listener.CustomerDailyImportListener;
import com.examplsss.demo.service.UserService;
import com.examplsss.demo.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 11:02
 */
@RestController
@RequestMapping("/testBoot")
@Slf4j
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


    @Operate(desc = "操作日志", type = "查询list")
    @GetMapping("/user/list")
    public JSONObject list() {
        JSONObject jsonObject = new JSONObject();
        List<User> list = userService.list();
        jsonObject.put("list", list);
        return jsonObject;
    }

    @Operate(desc = "操作日志", type = "根据id查询list")
    @GetMapping("/user/listById")
    public JSONObject listById(String id) {
        JSONObject jsonObject = new JSONObject();
        List<User> list = userService.listById(id);
        jsonObject.put("list", list);
        return jsonObject;
    }


    @Operate(desc = "操作日志", type = "根据id查询list")
    @PostMapping("/user/imports")
    public JSONObject imports(@RequestParam("file") MultipartFile file) {
        JSONObject jsonObject = new JSONObject();

        try {
            List<TestExcelDTO> reqCustomerDailyImports = EasyExcel.read(file.getInputStream())
                    // 这个转换是成全局的， 所有java为string,excel为string的都会用这个转换器。
                    // 如果就想单个字段使用请使用@ExcelProperty 指定converter
                    // 注册监听器，可以在这里校验字段
                    .registerReadListener(new CustomerDailyImportListener())
                    .head(TestExcelDTO.class)
                    .sheet()
                    .headRowNumber(1)
                    .doReadSync();
            log.info("读取的数据为{}",reqCustomerDailyImports);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return jsonObject;
    }


}
