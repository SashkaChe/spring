package ru.neutrino.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class Advice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

	System.out.println("............I'M EXECUTED BEFORE DEPOSIT METHOD...................");

		Object ret = invocation.proceed();

		System.out.println("............I'M EXECUTED AFTER DEPOSIT METHOD...................");

		return ret;
	}
}
