package com.esraa.jobportalbackend.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger logger = LoggerFactory.getLogger(ValidationAspect.class);


    @Around("execution(* com.esraa.jobportalbackend.service.JobService.getJob(..)) && args(id)")
    public Object validateAndUpdate(ProceedingJoinPoint pjp , int id) throws Throwable {

        if(id<0)
            id=-id;

        Object obj = pjp.proceed(new Object[]{id});


        return obj;
    }

}
