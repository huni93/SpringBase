package ch07_Aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ArticleCacheAdvice {
	private Map<Integer,Article> cache = new HashMap<Integer,Article>();
	//cache(1,Aticle(1)객체)저장되어 있음
	
	@Around("execution(public * *..ReadArticleService.*(..))")
	public Article cache(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[ACA] cache before 실행");
		//joinPoint.getArgs() : 핵심알고리즘의 매개변수 목록
		//id : 1
		
		Integer id = (Integer)joinPoint.getArgs()[0];
		Article article = cache.get(id);
		if(article != null) { //기존에 Article 객체 저장되어 있음
			System.out.println("[ACA] cache에서 Article["+id+"]가져옴");
			return article;
		}
		
		Article ret = (Article)joinPoint.proceed(); //다음 메서드를 실행.
		//ret : Article(1) 객체. 핵심 알고리즘이 리턴객체
		System.out.println("[ACA] cache after 실행");
		if(ret != null) {
			cache.put(id, ret);
			System.out.println("[ACA] cache에 Article["+id+"]객체를 추가함");
			
		}
	return ret;
	}
	

}
