package com.example.aop;

import com.mysql.cj.jdbc.ConnectionImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;

@Aspect
@Component
public class DataSourceAspect {

    @Around("target(javax.sql.DataSource)")
    public Object getConnectionInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("DataSource Tracker : " + proceedingJoinPoint.getSignature());
        Object returnValue = proceedingJoinPoint.proceed();
        System.out.println("Return value before proxy block: " + returnValue);

        if (returnValue instanceof Connection) {
            Connection con =   (Connection) Proxy.newProxyInstance(ConnectionImpl.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionInvocationHandler((Connection) returnValue));
            return con;
        }

        return returnValue;
    }
}