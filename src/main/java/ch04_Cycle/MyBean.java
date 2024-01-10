package ch04_Cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements BeanNameAware,ApplicationContextAware,
InitializingBean,DisposableBean{
 public MyBean() {
	 System.out.println("MyBean");
 }
 @Override
 public void destroy() throws Exception {
	 System.out.println("DisposableBean.destroy()");
}	 
 public void setProperty1(String value) {
	 System.out.println("MyBean.setProperty1()");
 }
 public void customInit() {
	 System.out.println("MyBean.customInit()");
 }
 public void customDestroy() {
	 System.out.println("MyBean.customDestroy()");
 }
 @Override
 public void afterPropertiesSet() throws Exception {
	 System.out.println("InitializingBean.afterPropertiesSet()");		
	}
 @Override
 public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContext.setApplicationContext()");		
	}
 @Override
 public void setBeanName(String name) {
	 System.out.println("BeanNameAware.setBeanName");
 }
}
