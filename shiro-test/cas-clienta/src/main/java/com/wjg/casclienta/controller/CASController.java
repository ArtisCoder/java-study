package com.wjg.casclienta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by jingang.wu on 2019/9/7
 */
@Controller
public class CASController {

    @RequestMapping("index")
    public String index(ModelMap map) {
        map.addAttribute("name", "clien B");
        return "index";
    }

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }
}
