package ch04_Cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyExtension implements BeanPostProcessor {
public MyExtension() {
	System.out.println("MyExtension");
}
public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor.postProcessAfterInitialization()");
		return bean;
	}
public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
	System.out.println("BeanPostProcessor.postProcessBeforeInitialization()");
	return bean;
	}
}
