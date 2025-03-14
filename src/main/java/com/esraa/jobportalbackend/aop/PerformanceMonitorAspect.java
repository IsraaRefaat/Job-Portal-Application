package com.esraa.jobportalbackend.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private final Logger logger = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.esraa.jobportalbackend.service.JobService.*(..) )")
    public Object monitorTime(ProceedingJoinPoint pjp) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object obj = pjp.proceed();

        long endTime = System.currentTimeMillis();


        logger.info("Performance Monitor Time in {} : {}ms", pjp.getSignature().getName(),endTime - startTime);

        return obj;

    }
}
