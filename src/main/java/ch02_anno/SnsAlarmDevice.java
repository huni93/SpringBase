package ch02_anno;

public class SnsAlarmDevice implements AlarmDevice {
    	
	public void alarm(String name) {
		System.out.println(name + "에서 침입 탐지됨. 신고 요망");

	}

}
