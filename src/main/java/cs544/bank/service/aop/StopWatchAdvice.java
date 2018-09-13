package cs544.bank.service.aop;

import cs544.bank.logging.ILogger;
import cs544.bank.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

/**
 * User: franc
 * Date: 12/09/2018
 * Time: 6:00
 */
@Aspect
public class StopWatchAdvice {


    private ILogger logger ;

    @Around("within(cs544.bank.service.*)")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        logger.log(String.format("Time to execute save = (%s) ms\n",totaltime));
        return retVal;
    }


    public void setLogger(ILogger logger) {
        this.logger = logger;

    }
}
