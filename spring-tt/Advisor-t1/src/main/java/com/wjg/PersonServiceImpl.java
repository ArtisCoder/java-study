package com.wjg;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * created by jingang.wu on 2019/9/6
 */
public class PersonServiceImpl implements BaseService {

    public void eat() {
        System.out.println("eat...");
    }

    public void wc() {
        System.out.println("wc...");
    }
}


