package book;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import module.BookDataSet;
import module.BookVO;

public class BookStart {
/*
메인 화면 -> 메뉴 나오고 작업

	1.책 목록 
	2.책 등록 
	3.책 수정 
	4.책 삭제 
	5.책 검색->책 정보 입력받아 정보 출력 
	6.책 종료

메뉴 나오고 작업

	책코드=
	책이름=
	작가=
	출판사=
	가격=
	출판년도=
	*/
	
	Scanner scan = new Scanner(System.in);
	
	public BookStart() {
		// 현재 등록되어있는 사원목록 
		BookDataSet.dataSet();//초기 데이터 셋팅
		do {
			try {//예외처리
				System.out.print(menu());
				int inMenu = Integer.parseInt(scan.nextLine());
				if(inMenu==6) {//종료
					bookStop();
				}else if(inMenu==1) {//책목록
					bookListOutput();
				}else if(inMenu==2) {//책등록
					bookInsert();
				}else if(inMenu==3) {//수정
					bookEdit();
				}else if(inMenu==4) {//삭제
					bookDel();
				}else if(inMenu==5) {//검색
					getNameSearch();
				}else {
					throw new Exception();
				}
			}catch(Exception e) {
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}while(true);
		
	}
	
	//1.책 목록 
	public void bookListOutput() {
		titlePrint();//책 제목 출력 
		
		//맵의 모든 value(vo객체)를 구하여 목록을 출력
		Collection<BookVO> book = BookDataSet.bookList.values();
		Iterator<BookVO> i = book.iterator();
		
		while(i.hasNext()) {
			BookVO v = i.next();
			System.out.println(v.toString());
		}
	}
	public void titlePrint() {
		System.out.println("책코드\t책이름\t작가\t출판사\t가격\t출판년도");
	}
	
	//2.책 등록 
	//책코드= / 책이름= / 작가= / 출판사= / 가격= / 출판년도=
	
	public void bookInsert() {
		BookVO vo = new BookVO();//입력받은 책 정보를 저장할 vo
		System.out.print("책 코드->");
		vo.setBookCode(Integer.parseInt(scan.nextLine()));
		System.out.print("책 이름->");
		vo.setBookName(scan.nextLine());
		System.out.print("작가->");
		vo.setBookAuthor(scan.nextLine());
		System.out.print("출판사->");
		vo.setBookPublisher(scan.nextLine());
		System.out.print("가격=->");
		vo.setBookPrice(Integer.parseInt(scan.nextLine()));
		System.out.print("출판년도->");
		vo.setBookYear(Integer.parseInt(scan.nextLine()));
		
		//컬렉션에 vo 추가
		BookDataSet.bookList.put(vo.getBookCode(), vo);
		System.out.println("책이 등록되었습니다.");
	}
	
	//3.책 수정 
	public void bookEdit() {
		//어떤 책 정보를 수정할 것인지 입력 받는다 
		System.out.print("수정할 책 코드->");
		int editBook = Integer.parseInt(scan.nextLine());
		
		System.out.print("수정할 항목[1.가격, 2.출판년도]");
		String editMenu = scan.nextLine();
		if(editMenu.equals("1")) {//가격수정
			bookPriceEdit(editBook);
		}else if(editMenu.equals("2")) {//출판년도 수정 
			bookYearEdit(editBook);
		}else {
			System.out.println("수정 메뉴를 잘못 선택하였습니다.");
		}

	}
	
	//3.1 가격 수정
	public void bookPriceEdit(int book) {
		BookVO vo = BookDataSet.bookList.get(book);// 수정할 책 가격 
		System.out.print("수정할 가격->");
		vo.setBookPrice(Integer.parseInt(scan.nextLine()));;//책 가격 변경 
		System.out.println(vo.getBookName()+"의 가격이"+vo.getBookPrice()+"로 변경되었습니다.");
	}
	//3.2 년도 수정
	public void bookYearEdit(int book) {
		BookVO vo = BookDataSet.bookList.get(book);
		System.out.print("수정할 년도->");
		vo.setBookYear(Integer.parseInt(scan.nextLine()));;
		System.out.println(vo.getBookName()+"의 년도가"+vo.getBookYear()+"로 변경되었습니다.");
	}
	
	
	//4.책 삭제 
	public void bookDel() {
		System.out.print("삭제할 책의 코드번호->");
		int bookCode = Integer.parseInt(scan.nextLine());
		BookDataSet.bookList.remove(bookCode);//객체가 지워짐.
		System.out.println(bookCode+"코드번호의 책 정보가 삭제되었습니다.");
	}
	
	//5.책 검색->책 정보 입력받아 정보 출력 
	public void getNameSearch() {
		System.out.print("검색할 책명->");
		String searchName = scan.nextLine();
		
		//컬렉션으로 반복문을 돌린다.VO
		Collection<BookVO> list = BookDataSet.bookList.values();
		Iterator<BookVO> ii = list.iterator();//제네릭을 써서 이터레이터를 만든다.
		int cnt=0;
		while(ii.hasNext()) {
			BookVO v = ii.next();
			if(v.getBookName().equals(searchName)) {
				System.out.println(v.toString());
				//입력 받은 데이터가 책명과 동일한지 체크 
				cnt++;
			}
		}
		System.out.println(cnt+"명이 검색되었습니다.");
	}
	
	//6.책 종료 - 입력하면 파일을 저장하고 종료
	public void bookStop() {//void를 붙여주는 이유는?
		try {
			File file = new File("/Users/apple/Desktop/TestFolder/book.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(BookDataSet.bookList);
			oos.close();
			fos.close();
		
		}catch(Exception e){
			System.out.println("파일 저장 중 문제 발생!"+e.getMessage());
			e.printStackTrace();
		}
		System.exit(0);//System.exit 해주는 이유?
	}
	
	public String menu() {
		return "메뉴[1.책 목록, 2.등록, 3.수정, 4.삭제, 5.검색, 6.종료]->";
	}
	
	public static void main(String[] args) {
		new BookStart();

	}

}
