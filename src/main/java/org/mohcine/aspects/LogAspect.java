package org.mohcine.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {
    Logger logger = Logger.getLogger(LogAspect.class.getName());
    @Around("@annotation(org.mohcine.aspects.Log)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long t1 = System.currentTimeMillis();
       logger.info("From Logging Aspects ... Before " + proceedingJoinPoint.getSignature());
        Object result=proceedingJoinPoint.proceed();
        logger.info("From Logging Aspects ... After " + proceedingJoinPoint.getSignature());
        long t2 = System.currentTimeMillis();
        logger.info("Duration : "+ (t1-t2));
        return result;
    }
}
