package com.aceyan.framework.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * 接口适配器
 *
 * @author yanling
 * @time 2018-01-09-15:54*/

@Aspect
@Order(0)
@Component
public class ApiAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiAspect.class);
    /**
     *定义一个切入点.
     *解释下：
     *
     * ~第一个 * 代表任意修饰符及任意返回值.
     * ~第二个 * 任意包名
     * ~第三个 * 代表任意方法.
     * ~第四个 * 定义在web包或者子包
     * ~第五个 * 任意方法
     * ~ ..匹配任意数量的参数.
     */
    @Pointcut("execution(public * com.boot.*.*.*(..))")
    public void apiController(){}
   /* @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMethod(){}*/

   @Around("apiController()")
    public Object doValidate(ProceedingJoinPoint pjp) throws Throwable {
        Object object = pjp.proceed();
        LOGGER.info("doValidate");
       LOGGER.info("demo... before");
       // 接收到请求，记录请求内容
       LOGGER.info("WebLogAspect.doBefore()");
       ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = attributes.getRequest();
       // 记录下请求内容
       LOGGER.info("URL : " + request.getRequestURL().toString());
       LOGGER.info("HTTP_METHOD : " + request.getMethod());
       LOGGER.info("IP : " + request.getRemoteAddr());
       LOGGER.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName()+ "." + pjp.getSignature().getName());
       LOGGER.info("ARGS : " + Arrays.toString(pjp.getArgs()));
       //获取所有参数方法一：
       Enumeration<String> enu=request.getParameterNames();
       while(enu.hasMoreElements()){
           String paraName=(String)enu.nextElement();
           System.out.println(paraName+": "+request.getParameter(paraName));
       }
        return object;
    }


    //@Before("apiController()")
    public void doInjectRequest(JoinPoint joinPoint) {
        LOGGER.info("demo... before");
        // 接收到请求，记录请求内容
        LOGGER.info("WebLogAspect.doBefore()");
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        LOGGER.info("URL : " + request.getRequestURL().toString());
        LOGGER.info("HTTP_METHOD : " + request.getMethod());
        LOGGER.info("IP : " + request.getRemoteAddr());
        LOGGER.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName());
        LOGGER.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        //获取所有参数方法一：
        Enumeration<String> enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));
        }
    }


    //@After("apiController()")
    public void authority(){
        System.out.println("模拟权限检查");
    }
}

