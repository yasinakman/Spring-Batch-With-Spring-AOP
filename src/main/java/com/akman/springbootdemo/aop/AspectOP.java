package com.akman.springbootdemo.aop;

import com.akman.springbootdemo.model.User;
import com.akman.springbootdemo.service.userservice.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@AllArgsConstructor
@Slf4j
public class AspectOP {

    private final UserService userService;

    @Pointcut("execution(* com.akman.springbootdemo.service.userservice.UserService..*(..))")
    public void testPointCut() {
    }

    @AfterThrowing(pointcut = "testPointCut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        String message = joinPoint.getSignature().getName() +  " - exception: " + e.getMessage();
    }

    @AfterReturning(pointcut = "testPointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        if (result != null && result.getClass().equals(User.class)) {
            User user = (User) result;
        }
    }
}
