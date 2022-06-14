package pac;

public class Information {

	int num = 1234;
	protected String userid = "goguma";
		
	protected Information(){
		System.out.println("Information의 생성자메소");
	}
	String getUserid() {
		return userid;
	}
	public static Information getInstance() {
		return new Information();
	}

}
