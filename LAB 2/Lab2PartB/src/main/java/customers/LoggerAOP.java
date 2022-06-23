package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@Aspect
public class LoggerAOP {

    @After("execution(* customers.EmailSender.sendEmail(..))")
    public void traceaftermethod(JoinPoint joinpoint) {
        EmailSender emailSender = (EmailSender) joinpoint.getTarget();
        Object[] args = joinpoint.getArgs();
        String email = (String)args[0];
        String message = (String)args[1];
        System.out.print(LocalDateTime.now() + " method = "+ joinpoint.getSignature().getName());
        System.out.println("address " + email + " " + "message =" + message + " outgoing mail server is" + emailSender.outgoingMailServer);
    }
}
