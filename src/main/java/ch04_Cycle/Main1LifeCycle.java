package ch04_Cycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1LifeCycle {

	public static void main(String[] args) {
		useXml();
        useJava();

	}
private static void useXml() {
	System.out.println("====XML Meta====");
	String configLocation = "classpath:ch04_Cycle/container_LifeCycle.xml";
	AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
	ctx.close();
}

private static void useJava() {
	System.out.println("====Java Meta====");
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigForLifeCycle.class);
	ctx.close();
}
}
