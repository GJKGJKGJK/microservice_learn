package com.gjk.a.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * AClient
 *
 * @author: gaojiankang
 * @date: 2022/9/20 10:51
 * @description:
 */
@FeignClient("service-b")
@Component
public interface AClient {

    @GetMapping("/add")
    public String add();
}
