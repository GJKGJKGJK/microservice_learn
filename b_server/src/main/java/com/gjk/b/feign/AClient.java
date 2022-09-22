package com.gjk.b.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * AClient
 *
 * @author: gaojiankang
 * @date: 2022/9/20 9:24
 * @description:
 */
@FeignClient("server-a")
@Component
public interface AClient {

    /**
     * 新增
     * @return
     */
    @GetMapping("/a/add")
    public String add();
}
