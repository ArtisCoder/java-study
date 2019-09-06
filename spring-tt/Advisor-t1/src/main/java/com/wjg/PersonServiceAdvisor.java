package com.wjg;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * created by jingang.wu on 2019/9/6
 */
public class PersonServiceAdvisor implements PointcutAdvisor {

    private Advice advice; //次要业务与其执行顺序
    private Pointcut pointCut;


    @Override
    public Pointcut getPointcut() {
        return pointCut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }


    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Pointcut getPointCut() {
        return pointCut;
    }

    public void setPointCut(Pointcut pointCut) {
        this.pointCut = pointCut;
    }
}
