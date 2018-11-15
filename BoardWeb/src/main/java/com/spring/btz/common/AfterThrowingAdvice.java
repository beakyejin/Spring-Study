package com.spring.btz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	@Pointcut("execution(* com.spring.btz..*Impl.*(..))")
	public void allPointcut() {}
	
	@AfterThrowing(pointcut="allPointcut()", throwing="exceptionObj")
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[예외 처리] " + method 
				+ "() 메소드 수행 중 발생된 예외 메세지 : " + exceptionObj.getMessage());
		
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력되었습니다.");
		} else if(exceptionObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다.");
		} else if(exceptionObj instanceof Exception) {
			System.out.println("문제가 발생하였습니다.");
		}
	}
	
}
