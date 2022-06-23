package bank.aop;

import bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class JmsAdvice {


    @Autowired
    private Logger logger;

    @After("execution(* bank.jms.*.*(..))")
    public void traceaftermethod(JoinPoint joinpoint) {

        logger.log(joinpoint.getSignature().getName());

    }
}
