package com.wjg;

import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by jingang.wu on 2019/9/6
 */
public class TestMain {

    public static void main(String [] args) {

        ApplicationContext factory = new ClassPathXmlApplicationContext("spring_config.xml");
        BaseService personProxy = (BaseService) factory.getBean("personProxy");
        personProxy.eat();
        personProxy.wc();

    }

}

