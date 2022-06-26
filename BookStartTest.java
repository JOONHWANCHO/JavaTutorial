import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import module.BookDataSet;
import module.BookVO;

public class BookStartTest {

	Scanner scan = new Scanner(System.in);
	
	public BookStartTest() {
		BookDataSet.dataSet();
		do {
			try {
				System.out.print(menu());
				int inMenu = Integer.parseInt(scan.nextLine());
				if(inMenu==6) {
					bookStop();
				}else if(inMenu==1) {
					bookListOutput();
				}else if(inMenu==2) {
					bookInsert();
				}
				
			}catch(Exception e) {
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}while(true);
	}
	
	public void bookStop() {
		try {
			File f = new File("/Users/apple/Desktop/TestFolder/book.txt");
		}catch(Exception e) {
			System.out.println("사원을 파일로 저장예외 발생!"+e.getMessage());
		}
		System.exit(0);
	}
	
	//1번 리스트
	public void bookListOutput() {
		titlePrint();
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
	
	//2번 등록
	public void bookInsert() {
		BookVO vo = new BookVO();
		System.out.print("책코드");
		vo.setBookCode(Integer.parseInt(scan.nextLine()));
		System.out.print("책이름->");
		vo.setBookName(scan.nextLine());
		System.out.print("작가->");
		vo.setBookAuthor(scan.nextLine());
		System.out.print("출판사");
		vo.setBookPublisher(scan.nextLine());
		System.out.print("가격");
		vo.setBookPrice(Integer.parseInt(scan.nextLine()));
		System.out.print("출판년도");
		vo.setBookYear(Integer.parseInt(scan.nextLine()));
	}
	
	
	public String menu() {
		return "메뉴[1.책 목록, 2.등록, 3.수정, 4.삭제, 5.검색, 6.종료]->";
	}
	
	public static void main(String[] args) {
		new BookStartTest();

	}

}
