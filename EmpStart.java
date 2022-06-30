

import java.util.List;
import java.util.Scanner;

import employeesOOP.EmpDAO;
import employeesOOP.EmpVO;

public class EmpStart {
	Scanner s = new Scanner(System.in);
	public EmpStart() {
		start();
	}
	public void start() {
		do {
			String menu = menuShow();
			if(menu.equals("1")) {//회원목록
				EmpList();
			}else if(menu.equals("2")) {//회원등록
				
			}else if(menu.equals("3")) {//회원수정
				
			}else if(menu.equals("4")) {//회원삭제
				
			}else if(menu.equals("5")) {//프로그램 종료
				EmpClose();
			}
			
		}while(true);
	}
	//회원목록
	public void EmpList() {
		//ㅇ회원목록 DB에서 선택할수 있게 메소드를 호출
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
