package ch05_Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {
//joinPoint : 호출되는 메서드의 실행 순서 저장하는 객체.
	public Object logging(ProceedingJoinPoint joinPoint)
	throws Throwable{
		System.out.println("[LA]로그 시작");
		StopWatch sw = new StopWatch();
		sw.start(); // 시작
		Object ret = joinPoint.proceed();
		//다음 메서드 호출. 여기서는 핵심알고리즘.
		sw.stop();
		System.out.println("[LA]메서드 실행 시간:"
		+sw.getTotalTimeMillis() + "밀리초");
		return ret;
		
	}
}
