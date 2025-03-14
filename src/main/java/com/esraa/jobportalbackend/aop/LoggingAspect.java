package com.esraa.jobportalbackend.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // return-type Class-Name.methodName(args)

    @Before("execution(* com.esraa.jobportalbackend.service.JobService.*(..) )")
    public void MethodCalled(JoinPoint jp) {
        logger.info("LoggingAspect"+ jp.getSignature().getName());
    }

    @After("execution(* com.esraa.jobportalbackend.service.JobService.*(..) )")
    public void logMethodExecuted(JoinPoint jp) {
        logger.info("Method Executed "+jp.getSignature().getName());
    }


    @AfterThrowing("execution(* com.esraa.jobportalbackend.service.JobService.*(..) )")
    public void logMethodCrashed(JoinPoint jp) {
        logger.info("Method has some issues "+jp.getSignature().getName());
    }



    @AfterReturning("execution(* com.esraa.jobportalbackend.service.JobService.*(..) )")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        logger.info("Method Executed Successfully "+jp.getSignature().getName());
    }

}
