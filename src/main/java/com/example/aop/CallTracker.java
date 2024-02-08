package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CallTracker {

    @Pointcut("within(com..service.*) || within(com..repo.*)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object logBeforeMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Method is Starting : " + proceedingJoinPoint.getSignature().getName());
        Object returnValue = proceedingJoinPoint.proceed();
        System.out.println("Method Executed :" + proceedingJoinPoint.getSignature().getName());
        return returnValue;
    }
}
