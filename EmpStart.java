package employeesOOP;

import java.util.List;
import java.util.Scanner;

public class EmpStart {
	Scanner s = new Scanner(System.in);
	public EmpStart() {
		start();
	}
	public void start() {

		do {
			try {
				String menu = menuShow();
				if(menu.equals("1")) {//회원목록
					empList();
				}else if(menu.equals("2")) {//회원등록
					empAdd();
				}else if(menu.equals("3")) {//회원수정
					empEdit();
				}else if(menu.equals("4")) {//회원삭제
					
				}else if(menu.equals("5")) {//프로그램 종료
					EmpClose();
				}
			}catch(Exception e) {
				System.out.println("잘못된 정보가 입력되었습니다.");
			}
			
		}while(true);
		
	}
	//회원정보 수정 
	public void empEdit() {
		EmpVO vo = new EmpVO();
		System.out.print("수정할 회원번호->");
		vo.setMem_id(Integer.parseInt(s.nextLine()));

		//수정할 항목
		System.out.print("수정할 항목선택[1.연락처, 2.부서명, 3.이메일]->");
		String editField = s.nextLine();
		if(editField.equals("1")) {
				vo.setFieldName("phone");
				System.out.print("수정할 연락처->");
			}else if(editField.equals("2")) {
				vo.setFieldName("depart");
				System.out.print("수정할 부서명->");
			}else if(editField.equals("3")) {
				vo.setFieldName("email");
				System.out.print("수정할 이메일->");
			}
			vo.setPhone(s.nextLine());
		
			EmpDAO dao = EmpDAO.getInstance();
			int cnt = dao.empUpdate(); // 필드네임, 수정할 값 3개가 들어가 있다. 
			if(cnt>0) {
				System.out.println(vo.getPhone()+"으로 수정되었습니다.");
			}else {
				System.out.println("수정에 실패하였습니다.");
			}
			
	}
	
	//회원목록
	public void empAdd() {
		//항목: 회원번호, 이름, 부서명, 연락처, 이메일 
		//입력받은 데이터를 VO에 저장하기 위해서 객체를 생성
		EmpVO vo = new EmpVO();
		System.out.print("회원번호->");
		vo.setMem_id(Integer.parseInt(s.nextLine()));
		
		System.out.print("이름->");
		vo.setUsername(s.nextLine());
		
		System.out.print("부서명->");
		vo.setDepart(s.nextLine());
		
		System.out.print("연락처");
		vo.setPhone(s.nextLine());
		
		System.out.print("이메일");
		vo.setEmail(s.nextLine());
		
		EmpDAO dao = new EmpDAO();
		int cnt = dao.empInsert(vo);
		if(cnt>0) {
			System.out.println(vo.getUsername()+"이 회원등록되었습니다.");
		}else {
			System.out.println("회원등록에 실패하였습니다.");
		}
	}
	
	public void empList() {
		//회원목록 DB에서 선택할수 있게 메소드를 호출
		EmpDAO dao =EmpDAO.getInstance();
		//EmpDAO dao = new EmpDAO(); -< 이렇게도 가능하다. 
		
		//EmpDAO를 맏늘어 주고 삽입 
		List<EmpVO> list = dao.empSelect();
		for(int i=0; i<list.size(); i++) {
			EmpVO vo = list.get(i);
			System.out.printf("%6d %12s %10s %16s %20s\n", 
					vo.getMem_id(), vo.getUsername(), vo.getDepart(), vo.getPhone(), vo.getEmail());
			//최환되는 값들은 vo에 저장된다.
		}
	}
	//종료
	public void EmpClose() {
		System.exit(0);
	}
	
	//메뉴
	public String menuShow() {
		System.out.print("메뉴[1.회원목록, 2.회원등록, 3.회원수정, 4.회원삭제, 5.종료]->");
		//메뉴 입력
		return s.nextLine();
	}
	public static void main(String[] args) {
		new EmpStart();

	}

}
