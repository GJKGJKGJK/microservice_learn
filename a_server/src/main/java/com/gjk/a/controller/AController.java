package com.gjk.a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AController
 *
 * @author: gaojiankang
 * @date: 2022/9/19 20:19
 * @description:
 */

@RestController
@RequestMapping("/a")
public class AController {

    @GetMapping("/add")
    public String add(){
        System.out.println("调用/a/add接口");
        return "/a/add";
    }
}
