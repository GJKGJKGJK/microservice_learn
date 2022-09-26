package com.gjk.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gjk.a.feign.BClient;

/**
 * AController
 *
 * @author: gaojiankang
 * @date: 2022/9/19 20:19
 * @description:
 */
@RefreshScope
@RestController
public class AController {


    @Autowired
    private BClient bClient;

    @Value("${user.id}")
    private String userId;

    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private String userAge;

    @GetMapping("/add")
    public String add(){
        System.out.println("调用/a/add接口");
//        bClient.add();
        return "调用 /a/add ，requst param userId:{" + userId + "}, userName:{" + userName + "}, userAge:{" + userAge + "}";

    }
}
