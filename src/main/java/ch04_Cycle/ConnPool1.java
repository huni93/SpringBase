package ch04_Cycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ConnPool1 implements InitializingBean,DisposableBean{
	
public void destroy() throws Exception {
	System.out.println("destroy()");
	
}
public void afterPropertiesSet() throws Exception {
		System.out.println("ConnPool1.afterPropertiesSet()");
		
	}
}
