package ch02_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfig {

	public static void main(String[] args) {
		ApplicationContext ctx =
				new AnnotationConfigApplicationContext(SpringAnnotation.class);
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
