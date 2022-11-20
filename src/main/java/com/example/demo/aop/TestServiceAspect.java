package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Aspect
@Configuration
@Slf4j
public class TestServiceAspect {

    @Before("execution(* com.example.demo.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        Arrays.stream(joinPoint.getArgs())
                .forEach(o -> log.info("request value: " + o.toString()));
    }

    @AfterReturning(value = "execution(* com.example.demo.controller.*.*(..))", returning = "returnValue")
    public void afterReturning(Object returnValue) {
        log.info("response value: " + returnValue);
    }

    @AfterThrowing(value = "execution(* com.example.demo.controller.*.*(..))", throwing = "throwValue")
    public void afterThrowing(Throwable throwValue) {
        log.info("throw value:" + throwValue);
    }

}
