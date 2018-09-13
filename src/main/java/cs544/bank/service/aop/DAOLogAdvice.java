package cs544.bank.service.aop;

/**
 * User: franc
 * Date: 12/09/2018
 * Time: 4:17
 */


import cs544.bank.logging.ILogger;
import cs544.bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;

@Aspect
public class DAOLogAdvice {

    private ILogger logger ;

    @After("within(cs544.bank.dao.*)")
    public void logDAOCall(JoinPoint joinPoint) throws ParseException {
        this.logger.log(String.format("Signature Call (%s) " ,joinPoint.getSignature().getName()));
        //System.out.printf(result);
    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }



}
