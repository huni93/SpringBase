package ch07_Aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = {"ch07_Aop"})
@EnableAspectJAutoProxy //annotation으로 AOP를 사용 설정.
public class ContainerAnnoAop {

}
