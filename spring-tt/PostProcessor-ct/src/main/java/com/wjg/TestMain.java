package com.wjg;

import com.wjg.service.BaseService;
import com.wjg.util.BeanDefined;
import com.wjg.util.BeanFactory;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * created by jingang.wu on 2019/9/4
 */
public class TestMain {

    public static void main(String[] args) throws Exception {

        //1.声明注册bean

        BeanDefined beanObj = new BeanDefined();
        beanObj.setBeanId("isomeService");
        beanObj.setClassPath("com.wjg.service.impl.ISomeService");


        BeanDefined beanObj2 = new BeanDefined();
        beanObj2.setClassPath("com.wjg.util.MyBeanPostProcessor");

        List configuration = new ArrayList();
        configuration.add(beanObj);//spring核心配置
        configuration.add(beanObj2);

        //2.声明一个Spring提供BeanFacotory
        BeanFactory factory = new BeanFactory(configuration);


        //3.开发人员向BeanFactory索要实例对象.
        BaseService t= (BaseService) factory.getBean("isomeService");
        System.out.println("t="+t);
        System.out.println(t.doSome());//HELLO MIKE
    }
}
