package ch06_Aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_aop06 {

	public static void main(String[] args) {
		String[]config = {"ch06_Aop/di06.xml","ch06_Aop/aop06.xml"

	};
		
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext(config);
		ReadArticleService service= ctx.getBean("readArticleService",ReadArticleService.class);
		System.out.println("==============");

		try {
			Article a1 = service.getArticleAndReadCnt(1);
			System.out.println("[main]a1=" + a1);
			Article a2 = service.getArticleAndReadCnt(1);
			System.out.println("[main]a1=2:"+(a1==a2));
			service.getArticleAndReadCnt(0);
			
		}catch(Exception e) {
			System.out.println("[main]"+e.getMessage());
			
		}
		
		
		
		
		
		
		
		
}}
