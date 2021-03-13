package ru.neutrino;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;



public class AdviceBefore implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)
	throws Throwable { 
		
		if ((Integer) args[0] == 100) {
		System.out.println("Вывод ДО: " + method.getName() + " " + args[0]);
		} else {
			System.out.println("Параметр метода не 100");	
		}
	}
}
