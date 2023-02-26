package com.shoulaxiao.bookweb.dal.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @athor : shoulaxiao
 * @description:
 * @date: 2021-03-16 19:55
 **/
@RestController
public class HealthCheckController {

    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "OK";
    }

}
