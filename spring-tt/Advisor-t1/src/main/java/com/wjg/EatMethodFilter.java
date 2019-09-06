package com.wjg;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;

public class EatMethodFilter implements MethodMatcher {

    /*
    * 方法没有重载方法，此时可以采用静态检测方式，只根据方法名称判断
    * 只想为personserviceimpol中的eat方法进行判断
    *
    * */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {

        String methodName = method.getName();
        if("eat".equals(methodName))
            return true;
        return false;
    }

    @Override
    public boolean isRuntime() {
        return false;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return false;
    }
}


