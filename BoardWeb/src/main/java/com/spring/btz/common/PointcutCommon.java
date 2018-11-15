package com.spring.btz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.spring.btz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.spring.btz..*Impl.get*(..))")
	public void getPointcut() {}
}
