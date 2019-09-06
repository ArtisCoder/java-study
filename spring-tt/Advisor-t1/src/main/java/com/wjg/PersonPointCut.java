package com.wjg;

import org.aopalliance.aop.Advice;
import org.springframework.aop.*;

public class PersonPointCut implements Pointcut
{
    private ClassFilter classFilter;
    private MethodMatcher methodMatcher;


    @Override
    public ClassFilter getClassFilter() {
        return classFilter;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }


    public void setClassFilter(ClassFilter classFilter) {
        this.classFilter = classFilter;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}

