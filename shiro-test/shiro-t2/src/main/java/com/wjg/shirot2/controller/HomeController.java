package com.wjg.shirot2.controller;

import com.wjg.shirot2.conf.IncorrectCaptchaException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by archerlj on 2017/6/30.
 */

@Controller
public class HomeController {

    @RequestMapping("/logoutTest")
    public String logout() {
        return "logoutTest";
    }

    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }

    // 同时支持get和post请求
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {

        System.out.println("HomeController.login");

        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        Object exception = request.getAttribute("shiroLoginFailure");
//        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (exception instanceof UnknownAccountException) {
                System.out.println("账户不存在");
                msg = "账户不存在或密码不正确";
            } else if (exception instanceof IncorrectCredentialsException) {
                System.out.println("密码不正确");
                msg = "账户不存在或密码不正确";
            } else if (exception instanceof IncorrectCaptchaException) {
                System.out.println("验证码不正确");
                msg = "验证码不正确";
            } else {
                System.out.println("其他异常");
                msg = "其他异常";
            }
        }

        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "login";
    }
}
