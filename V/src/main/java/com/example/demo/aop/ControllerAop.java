package com.example.demo.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ControllerAop {

	private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);
	
	private long startTime = 0L;
	private long endTime = 0L;
	
	@Before("execution(* com.example.demo.controller..*.*(..))")
	public void before(JoinPoint joinPoint) throws Exception {
		
		logger.info("-----------------------------info");
		
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;  
        HttpServletRequest request = sra.getRequest();
        
        String classType = joinPoint.getTarget().getClass().getName();    
        Class<?> clazz = Class.forName(classType);    
        String clazzName = clazz.getName();    
        String methodName = joinPoint.getSignature().getName(); 
        
        logger.info("---请求方法"+clazzName+"."+methodName+"()");
        
        logger.info("---method:"+request.getMethod());
        logger.info("---url:"+request.getRequestURL());
        logger.info("---param:"+request.getQueryString());
		
		
		startTime = System.currentTimeMillis();
		logger.info("---开始时间："+startTime);
	}
	
	@After("execution(* com.example.demo.controller..*.*(..))")
	public void after(JoinPoint joinPoint) {
		endTime = System.currentTimeMillis();
		logger.info("---结束时间："+endTime);
		logger.info("---耗时:"+(endTime-startTime)+" 毫秒");
	}
}
