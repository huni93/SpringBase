package ch03_xmlAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainXmlAnno {

	public static void main(String[] args) {
		ApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:ch03_xmlAnno/ContainerXmlAnno.xml");
//      아래 방법과 같이 여러 방법이있다.
//		String[] config = {"classpath:ch03_xmlAnno/ContainerXmlAnno.xml"};
//		ApplicationContext ctx1 = new ClassPathXmlApplicationContext(config);
		System.out.println("============container setting");
		Executor exec = ctx.getBean("executor",Executor.class);
		exec.addUnit(new WorkUnit());
		exec.addUnit(new WorkUnit());
		
		HomeController home = ctx.getBean("homeController",HomeController.class);
		System.out.println("==========homeController setting");
		home.checkSensorAndAlarm(); //출력 정보 없음
		home.showCameraImage();
		InfraredRaySensor windowSensor = ctx.getBean("windowSensor",InfraredRaySensor.class);
		windowSensor.foundObject();
		home.checkSensorAndAlarm();
	

}

}