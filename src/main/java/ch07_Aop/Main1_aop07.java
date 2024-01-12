package ch07_Aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1_aop07 {

	public static void main(String[] args) {
		String[] config ={"ch07_Aop/aop07.xml"};
		
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext(config);
		ReadArticleService service = ctx.getBean
				("readArticleService",ReadArticleService.class);
		System.out.println("=========================");
		
		try {
		Article a1 = service.getArticleAndReadCnt(1);
		System.out.println("[main]a1=" + a1);
		Article a2 = service.getArticleAndReadCnt(1);
		System.out.println("[main]a1=a2:" + (a1==a2));
		service.getArticleAndReadCnt(0);
		} catch(Exception e) {
			System.out.println("[main]"+e.getMessage());
		}
		
		//3.
		System.out.println("\n UpdateMemberInfoTraceAspect 연습");
		MemberService ms =
				ctx.getBean("MemberService",MemberService.class);
		ms.regist(new Member());
		ms.update("hong", new UpdateInfo());
		ms.delete("hong2", "test");
	}

}
