package cs544.bank.service.aop;

import cs544.bank.logging.ILogger;
import cs544.bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * User: franc
 * Date: 12/09/2018
 * Time: 6:07
 */
@Aspect
public class JMSLogAdvice {
    private ILogger logger ;



    @After("execution( * cs544.bank.jms.JMSSender.sendJMSMessage(..))")
    public void invoke(JoinPoint joinPoint) throws Throwable {
        Arrays.stream(joinPoint.getArgs()).forEach(msg-> {
            this.logger.log(String.format("Message(%s) JMSLogAdvice \n",msg));

        });





    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }
}
