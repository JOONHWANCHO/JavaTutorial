package employeesOOP;

public class EmpVO {
	//필요한 변수 선언, 멤버테이블에 있는 변수는 일차적으로 다 선언
	//접근제한자는 private으로 선언
	//컬렉션 객체들을 하나로묶는것 
	//묶어줬기 때문에 리턴 가능하다
	//컬렉션에서 저장된 순서 유지 ArrayList, LinkedList
	private int mem_id;
	private String username;
	private String depart;
	private String phone;
	private String email;
	private String writedate;
	//수정할 항목을 VO에 저장할 수 있다. 
	private String fieldName; //수정할 항목 
	
	public EmpVO() {
		
	}


	public int getMem_id() {
		return mem_id;
	}


	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDepart() {
		return depart;
	}


	public void setDepart(String depart) {
		this.depart = depart;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getWritedate() {
		return writedate;
	}


	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	//private으로 캡슐화 되어있어서 게터 세터가 없으면 외부에서 못쓴다.


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
