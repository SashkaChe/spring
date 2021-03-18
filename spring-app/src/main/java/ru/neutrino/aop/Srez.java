package ru.neutrino.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class Srez extends DynamicMethodMatcherPointcut {


	public boolean matches (Method method, Class<?> cls, Object[] args) {
	
		
		if ("getInt".equals(method.getName())) {
			
			return (Integer) args[0] == 100;
		}

		return false;
	}
	
	
	public ClassFilter getClassFilter() {
		
		return new ClassFilter() {
		
		public boolean matches(Class<?> cls) {
		return (cls == Solution.class);
	
		}
	};
	}
}

