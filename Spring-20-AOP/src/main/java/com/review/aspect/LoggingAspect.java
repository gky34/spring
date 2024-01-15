package com.review.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.review.controller.CourseController.*(..))")
//    private void pointcut(){}

//    @Before("pointcut()")
//    public void log(){
//        logger.info("Logger info ------");
//    }

    /**
     * we can combine above 2 different methods, which is @Before and execution as under methods
     */
//    @Before("execution(* com.review.controller.CourseController.*(..))")
//    public void beforeAdvice(){
//        logger.info("Logger info ------");
//    }

//    @Pointcut("execution(* com.review.repository.CourseRepository.findById(*))")
//    private void anyProductRepositoryFindById(){}
//
//    @Before("anyProductRepositoryFindById()")
//    public void beforeCourseRepoOperation(JoinPoint joinPoint){
//        logger.info("Before (findById) : -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }

    /**
     * class level
     * within we can't give the return type so we should define the path
     * inside of controller we want to control all methods
     */
//    @Pointcut("within(com.review.controller..*)")
//    private void anyControllerOperation(){}
//
    /**
     *  Class level annotation  @within
     *  We want to get all service class information
     */
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    private void anyServiceOperation(){
//    }
//

    /**
     *  We can combine both method in @Before annotation
     We want to see method, argument, target
     */
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before () -> Method : {} - Arguments : {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }
//

    /**
     * The @annotation designator just for METHOD level
     * Mostly we use for custom created annotation
     * WARNING
     * The @annotation limits the matching of jointPoint where has the given annotation
     * The @within matches if a class has the annotation
     */
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    private void anyDeleteCourseOperation() {
//    }

//    @Before("anyDeleteCourseOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint) {
//        logger.info("Before -> Method : {} - Arguments : {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    private void anyGetCourseOperation() {
//    }

    /**
     * @AfterReturning -> whenever request finish successfully
     * It's working key and value
     *
     */
//    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
//    public void afterReturningControllerAdvice(JoinPoint joinPoint, Object result){
//        logger.info("After returning -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
//    }

    /**
     *  @AfterReturning ->  We can get as a list too as below method
     *
     */
//    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
//    public void afterReturningControllerAdvice(JoinPoint joinPoint, List<Object> result){
//        logger.info("After returning(List) -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
//    }

    /**
     *  @AfterThrowing If you want to monitor business logic which trowing exception
     */
//    @AfterThrowing(pointcut = "anyGetCourseOperation()", throwing = "exception")
//    public void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception){
//        logger.info("After Throwing -> Method: {} - Exception: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
//    }

    /**
     * @After(finally) -> as the advice is executed either the method exits successfully or terminates
     * execution by throwing an Exception
     */
//    @After("anyGetCourseOperation()")
//    public void afterControllerAdvice(JoinPoint joinPoint) {
//        logger.info("After finally -> Method : {}", joinPoint.getSignature().toShortString());
//    }

    @Pointcut("@annotation(com.review.annotation.Loggable)")
    private void anyLoggableMethodOperation() {
    }

    /** @Around
     *  It contains code which is executed before and after
     *  The first parameter of the advice method must be of type of ProceedingJointPoint
     *  body of advice, calling proceed() which is providing execution time and we can separate before and after
     *  return a value from the advice method as the matched Jointpoint
     *
     */
    @Around("anyLoggableMethodOperation()")
    public Object anyLoggableMethodOperationAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        logger.info("Before () -> Method : {} - Parameters: {}", proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());
        Object results = null;
        try {
            results = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info("After -> Method: {} - Results: {}", proceedingJoinPoint.getSignature().toShortString(), results.toString());
        return results;
    }

}