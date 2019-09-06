package com.wjg;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.expression.MethodFilter;

import java.lang.reflect.Method;

/**
 * created by jingang.wu on 2019/9/6
 */
public class PersonMatchFilter implements ClassFilter {

    /*
     *  1. 一个接口会有多个实现类
     *  2。 判断当前实现类是不是我们织入的实现类
     * */
    public boolean matches(Class<?> clazz) {
        if (clazz == PersonServiceImpl.class)
            return true;
        return false;
    }
}

