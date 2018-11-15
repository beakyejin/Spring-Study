package com.spring.btz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	@Pointcut("execution(* com.spring.btz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.spring.btz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[공통로그]비지니스 로직 수행 전 동작");
	}
	
	
}
