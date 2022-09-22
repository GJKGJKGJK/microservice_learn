package com.gjk.a.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * BClient
 *
 * @author: gaojiankang
 * @date: 2022/9/20 10:51
 * @description:
 */
@FeignClient("server-b")
@Component
public interface BClient {

    @GetMapping("/b/add")
     String add();
}
