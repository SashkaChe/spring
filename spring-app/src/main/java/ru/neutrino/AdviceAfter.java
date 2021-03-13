package ru.neutrino;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;


public class AdviceAfter implements AfterReturningAdvice {
	
	
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
	
	if ((Integer) returnValue == 100) {
		System.out.println("100");
	} else {
		System.out.println("не 100");
	}
	
	}
	
}
