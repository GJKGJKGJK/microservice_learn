package com.gjk.b.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/b")
public class BController {


    @Autowired
    private AClient aClient;

    @GetMapping("/add")
    public String add(){
        aClient.add();
        System.out.println("调用/b/add接口");
        return "/b/add";
    }
}
