package ch02_anno;

public class Camera {
	
	private int number;
	
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Camera[number=" + number + "]";
				
	}

}
