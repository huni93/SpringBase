package ch03_xmlAnno;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype",proxyMode=ScopedProxyMode.TARGET_CLASS) //일회용 객체로 생성
public class Worker {
	
	public void work(WorkUnit unit) {
		System.out.println(this + ":work:" + unit);
	}

}
