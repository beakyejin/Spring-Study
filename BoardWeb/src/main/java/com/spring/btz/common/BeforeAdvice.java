/*package com.spring.btz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	@Pointcut("execution(* com.spring.btz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String  method = jp.getSignature().getName(); //클라이언트가 호출한 메소드 이름
		Object[] args = jp.getArgs(); //인자 목록
		
		System.out.println("[사전 처리] " + method + " () 메소드 ARGS정보: " + 
						args[0].toString() );
	}
}
*/