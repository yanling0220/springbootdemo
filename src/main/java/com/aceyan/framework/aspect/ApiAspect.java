/*
package com.aceyan.framework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

*/
/**
 * 接口适配器
 *
 * @author yanling
 * @time 2018-01-09-15:54
 *//*


@Aspect
@Order(0)
@Component
public class ApiAspect {
    @Pointcut("@target(com.aceyan.framework.annotation.ApiController)")
    public void apiController(){}
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMethod(){}

    @Around(value="apiController() && requestMethod() &&args(name)")
    public Object doValidate(ProceedingJoinPoint pjp,String name) throws Throwable {
        Object object = pjp.proceed();
        LOGGER.info("doValidate");

        return object;
    }


    @Before(value = "apiController() && requestMethod()")
    public void doInjectRequest() {
        LOGGER.info("demo... before");
    }


    @After("execution(* com.*.*.HelloAppliction.greeting(..))")
    public void authority(){
        System.out.println("模拟权限检查");
    }
}

*/
