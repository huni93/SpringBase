package ch03_xmlAnno;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
/*
 * 객체 생성 기본어노테이션
 * 
 * 1. 객체 생성 : @Component : container에 객체 추가
 * 2. 객체 주입(DI) :
 * @Autowired : 객체선택기준이 클래스의 자료형임.
 *  (required=false) : 객체가 없는 경우 주입안해도 됨.
 *  (required=true) : 주입할 객체가 반드시 container에 있어야 함. 기본값.
 * @Required : 객체선택기준이 클래스의 자료형임. 반드시 주입해야함. 주입할 객체가 없으면 오류발생.
 * @Resource("이름") : 컨테이너에서 "이름"을 가진 객체를 주입함.
 * 
 * 3. 그외
 * @Qualifier : 객체에 별명이 있는 경우 별명으로 객체를 인식함. @Autowired에 선택기준으로 사용함.
 * @Scope(...) : 일회용 객체를 생성함. @Component와 함께 사용함.
 * @PostConstruct : 객체 생성 후에 호출되는 메서드를 지정.
 * 
 * Container 생성
 * 1.@Configuration : container setting
 * 2.@Bean : 객체생성
 */
@Component
public class HomeController {

	List<InfraredRaySensor> sensors;
	@Autowired
	AlarmDevice alarmDevice;
	Viewer viewer;
	@Resource(name="camera1")
	private Camera camera1;
	@Resource(name="camera2")
	private Camera camera2;
	@Resource(name="camera3")
	private Camera camera3;
	@Resource(name="camera4")
	private Camera camera4;
	@Autowired(required=false)
	private Recorder recorder;
	
	@Autowired
	@Qualifier("intrusionDetection1")//별명을 가진 객체만 주입.
	public void setSensors(List<InfraredRaySensor> sensors) {
		this.sensors = sensors;
		
		for(InfraredRaySensor s : sensors) {
			System.out.println("센서등록:" + s);
		}
	}
	@PostConstruct  //객체가 완성된 후에 init() 메서드를 호출하도록 설정
	public void init() {
		viewer.add(camera1);
		viewer.add(camera2);
		viewer.add(camera3);
		viewer.add(camera4);
		System.out.println("recorder:" + recorder);
	}
	@Autowired
	public void prepare(AlarmDevice alarmDevice,Viewer viewer) {
		this.alarmDevice=alarmDevice;
		this.viewer=viewer;
	}
	public void setCamera1(Camera camera1) {
	    this.camera1=camera1;
	}
	public void setCamera2(Camera camera2) {
	    this.camera2=camera2;
	}
	public void setCamera3(Camera camera3) {
	    this.camera3=camera3;
	}
	public void setCamera4(Camera camera4) {
	    this.camera4=camera4;
	}
	public void checkSensorAndAlarm() {
		System.out.println("checkSensorAndAlarm:"+sensors);
		for(InfraredRaySensor s : sensors) {
			if(s.isObjectFounded()) {
				alarmDevice.alarm(s.getName());
			}
		}
	}
	public void showCameraImage() {
		viewer.draw();
	}
}
