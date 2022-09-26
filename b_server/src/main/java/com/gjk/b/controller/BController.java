package com.gjk.b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gjk.b.feign.AClient;

/**
 * BController
 *
 * @author: gaojiankang
 * @date: 2022/9/19 20:23
 * @description:
 */
@RefreshScope
@RestController
public class BController {



    @Value("${user.id}")
    private String id;
    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private String age;

    @GetMapping("/add")
    public String add(){
        System.out.println("调用/b/add接口");
        return "调用 /b/add ，requst param userId:{" + id + "}, userName:{" + name + "}, userAge:{" + age + "}";
    }
}
