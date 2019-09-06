package com.wjg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by jingang.wu on 2019/9/4
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello, world!";
    }
}
