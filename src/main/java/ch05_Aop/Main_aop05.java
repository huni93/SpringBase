package ch05_Aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main_aop05 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch05_Aop/aop05.xml");
		
		WriteImpl bean = ctx.getBean("write",WriteImpl.class);
		//LoggingAspect.loggin(..) 먼저 실행됨
		//logging()의 joinPoint.proceed() 문장으로 write() 실제로 호출됨
		bean.write();//기본 메서드
		//logging()의 joinPoint.proceed()문장으로 이후로 제어 이동
		
		System.out.println("===========");
		ReadImpl read = ctx.getBean("read",ReadImpl.class);
		//LoggingAspect.logging(...) 먼저 실행됨
		//logging()의 JointPoint.proceed()문장으로 read()실제로 호출됨
		System.out.println("[main]" + read.read());
		//logging()의 joinPoint.proceed()문장으로 이후로 제어 이동
		//ref 값을 main으로 전달함.
	
		
		
	}
	
	
	
	
}
