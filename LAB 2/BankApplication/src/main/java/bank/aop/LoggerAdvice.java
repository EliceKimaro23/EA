package bank.aop;

import bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggerAdvice {
    @Autowired
    private Logger logger;
    @After("execution(* bank.dao.*.*(..))")
    public void traceaftermethod(JoinPoint joinpoint) {
//        System.out.println("after execution of method "+joinpoint.getSignature().getName());
        logger.log(joinpoint.getSignature().getName());
    }
}
