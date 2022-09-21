package com.gjk.b.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BController
 *
 * @author: gaojiankang
 * @date: 2022/9/19 20:23
 * @description:
 */
@RestController
@RequestMapping("/b")
public class BController {


//    @Autowired
//    private AClient aClient;


    // 使用原生注解@Value()导入配置
    @Value("${user.id}")
    private String id;
    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private String age;

    @GetMapping("/add")
    public String add(){
//        aClient.add();
        System.out.println("调用/b/add接口");
        return "调用 /b/add ，requst param userId:{" + id + "}, userName:{" + name + "}, userAge:{" + age + "}";
    }
}
