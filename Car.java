package inheritance;

public class Car {
	int speed = 0;
	String color = "white";//blue
	String brend = "소나타";
	public Car() {
		System.out.println("Car()생성자매소드");
	}
	public Car(String color, String brend) {
		this.color = color;	
		this.brend = brend;
	
	}
	public void speedUp() {
		speed++;
		if(speed>=100) {
			speed=100;
		}
	}
	public void speedDown() {
		speed--;
		if(speed<=0) speed=0;
	}
}
