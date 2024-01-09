package ch03_xmlAnno;

public class InfraredRaySensor {
   	
	private String name;
	private boolean objectFounded;
	
	public InfraredRaySensor(String name) {  //생성자
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isObjectFounded() {
		return objectFounded;
	}
	public void setObjectFounded(boolean objectFounded) {
		this.objectFounded = objectFounded;
	}
	
	public void foundObject() {
		this.objectFounded = true;
	}
	
	@Override
	public String toString() {
		return "InfraredRaySensor [name=" + name + ", objectFounded=" + objectFounded + "]";
	}

}
