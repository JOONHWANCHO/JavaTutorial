package employess;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import module.EmpDataSet;
import module.EmpVO;

public class EmpStart {
	/*메일 화면 
	메뉴 나오고 작업
	1목록, 2등록, 3
	
	메뉴 나오고 작업
	1.목록, 2.등록 
	사원번호=
	잉름=
	부서명=
	연락처=
	*/
	Scanner scan = new Scanner(System.in);
	public EmpStart() {

		//현재 등록되어있는 사원목록 
		EmpDataSet.dataSet();//초기 데이터 셋팅 
		do {//처음에 무조건 실행해야 하는건 do while이 좋다.
			try {
			System.out.print(menu());
			//String inmenu = scan.nextLine();
			int inMenu = Integer.parseInt(scan.nextLine());
			if(inMenu==5) {//종료
				empStop();
			}else if(inMenu==1) {//사원목록(모든사원)
				empListOutput();
			}else if(inMenu==2) {//사원등록
				empInsert();// 사원등록 호출해 준다.
			}else if(inMenu==3) {//사원수정
				empEdit();
			}else if(inMenu==4) {
				empDel();
			}else if(inMenu==6) {//이름으로 사원검색 
				getNameSearch();
			}else {
				throw new Exception();
			}
			}catch(Exception e) {
				System.out.println("메뉴를 잘못입력하였습니다.");
			}
		}while(true);
	}
	//6.사원명으로 검색
	public void getNameSearch() {
		System.out.print("검색할 사원명->");
		String searchName = scan.nextLine();
		
		//컬렉션으로 반복문을 돌린다.
		//vo
		Collection<EmpVO> list = EmpDataSet.empList.values();
		Iterator<EmpVO> ii = list.iterator();//제네릭을 써서 이터레이터를 만든다.
		int cnt=0;
		while(ii.hasNext()) {
			EmpVO v = ii.next();
			if(v.getEmpName().equals(searchName)) {
				System.out.println(v.toString());
				//방금 입력 받은 이름이 데이터에 이름과 동일한지 체크 
				cnt++;
			}
		}
		System.out.println(cnt+"명이 겁색되었습니다.");
	}
	
	//4.사원 삭제 
	public void empDel() {
		System.out.print("삭제할 사원의 사원번호->");
		int empno = Integer.parseInt(scan.nextLine());
		EmpDataSet.empList.remove(empno);//객체가 지워짐
		System.out.println(empno+"번 사원의 정보를 삭제하였습니다.");
	}
	
	//3.사원수정 코드작성
	public void empEdit() {
		//어떤사원을 수정할 것인지 입력받는다. 
		System.out.print("수정할 사원번호->");
		int editEmpno = Integer.parseInt(scan.nextLine());
		
		System.out.print("수정할 항목[1.부서명, 2.연락처]->");
		String editMenu = scan.nextLine();
		if(editMenu.equals("1")) {//부서수정 
			departmentEdit(editEmpno);//수정할 사원명
		}else if(editMenu.equals("2")) {//연락처수정
			telEdit(editEmpno);
		}else {
			System.out.println("수정할 메뉴를 잘못선택하였습니다.");
		}
		
	}
	//3.1수정 파트 - 부서명수정
	public void departmentEdit(int empno) {
		EmpVO vo = EmpDataSet.empList.get(empno);//수정할 사원 정보가 넘어온다.
		System.out.print("수정할 부서명->");
		String editDepartName = scan.nextLine();
		vo.setDepartment(editDepartName);//부서명이 변경됨.
		System.out.println(vo.getEmpName()+"의 부서명이"+vo.getDepartment()+"로 변경되었습니다.");
	}
	//3.2수정 파트 - 연락처 수정
	public void telEdit(int empno) {
		EmpVO vo = EmpDataSet.empList.get(empno);
		System.out.print("수정할 연락처->");
		vo.setTel(scan.nextLine());
		System.out.println(vo.getEmpName()+"사원님의 연락처가"+vo.getTel()+"로 변경되었습니다.");
	}
	//사원목록 for inMenu==1
	public void empListOutput() {
		titlePrint();//제목출력
		//맵의 모든 value(vo객체)를 구하여 목록을 출력한다. 
		Collection<EmpVO> emp= EmpDataSet.empList.values();
		Iterator<EmpVO> i = emp.iterator();
		
		while(i.hasNext()) {
			EmpVO v = i.next();
			System.out.println(v.toString());
		}
	}
	public void titlePrint() {
		System.out.println("사원번호\t사원명\t부서명\t연락처");
	}
	
	//사원등록
	
	//종료
	//사원등록을 만들어서 
	public void empInsert() {
		EmpVO vo = new EmpVO();//입력받은 사원정보를 저장할 vo
		System.out.print("사원번호");
		vo.setEmpno(Integer.parseInt(scan.nextLine()));
		System.out.print("사원명->");
		vo.setEmpName(scan.nextLine());
		System.out.print("부서명->");
		vo.setDepartment(scan.nextLine());
		System.out.print("연락처->");
		vo.setTel(scan.nextLine());
		
		//컬렉션에 vo를 추가
		EmpDataSet.empList.put(vo.getEmpno(), vo);
		System.out.println("사원이 등록되었습니다.");
		
	}

	//사원정보가 있는 empList를 파일로 저장하고 종료한다.
	public void empStop() {
		try {
		File f = new File("/Users/apple/Desktop/TestFolder/employee.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(EmpDataSet.empList);
		
		oos.close();
		fos.close();//파일이 기록 됐다. 
		
		}catch(Exception e) {
			System.out.println("사원을 파일로 저장예외 발생!!"+ e.getMessage());
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public String menu() {
		return "메뉴[1.사원목록, 2.사원등록, 3.사원수정, 4.사원삭제, 5.종료, 6.검색]->";
	}
	public static void main(String[] args) {
		new EmpStart();

	}

}
