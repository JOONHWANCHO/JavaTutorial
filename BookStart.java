

import java.util.List;
import java.util.Scanner;

import java_report_book.BookDAO;
import java_report_book.BookVO;

public class BookStart {

	Scanner scan = new Scanner(System.in);
	BookDAO dao = new BookDAO();
	
	public BookStart() {
		start();
	}
	public void start() {
		do {
			try {
				String menu = menuShow();
				if(menu.equals("1")) {
					bookList();
				}else if(menu.equals("2")) {
					bookAdd();
				}else if(menu.equals("3")) {
					bookEdit();
				}else if(menu.equals("4")) {
					bookDel();
				}else if(menu.equals("5")) {
					bookClose();
				}else if(menu.equals("6")) {
					bookSearch();
				}
			}catch(Exception e) {
				System.out.println("잘못된 정보를 입력하였습니다.");
			}
		}while(true);
	}
	
	//회원검색
	public void bookSearch() {
		System.out.print("검색어->");
		String searchWord = scan.nextLine();
		bookPrint(dao.bookSelect(searchWord));
	}
	
	//회원목록
	public void bookList() {
		String searchWord = null;
		bookPrint(dao.bookSelect(searchWord));
	}
	
	//목록 출력 메소드
	public void bookPrint(List<BookVO> list) {
		for(int i=0; i<list.size(); i++) {
			BookVO vo = list.get(i);
			System.out.printf("%6d %12s %10s %16s %20s %20s\n",
					vo.getBookCode(), vo.getBookName(), vo.getBookAuthor(), vo.getBookPublisher(), vo.getBookPrice(), vo.getBookYear());
		}
	}
	
	//회원정보 삭제
	public void bookDel() {
		System.out.print("삭제할 책코드->");
		int bookCode = Integer.parseInt(scan.nextLine());
		BookDAO dao = new BookDAO();
		int result = dao.bookDelete(bookCode);
		if(result>0) {
			System.out.println(bookCode+"책이 삭제되었습니다.");
		}else {
			System.out.println(bookCode+"책 삭제가 실패하였습니다.");
		}
	}
	
	//회원정보 수정 
	public void bookEdit() {
		BookVO vo = new BookVO();
		System.out.print("수정할 책 코드->");
		vo.setBookCode(Integer.parseInt(scan.nextLine()));
		
		System.out.print("수정할 항목[1.가격, 2.출판년도 3.출판사]->");
		String editField = scan.nextLine();
		if(editField.equals("1")) {
			vo.setFieldBook("bookPrice");
			System.out.print("수정할 책 가격->");
		}else if(editField.equals("2")) {
			vo.setFieldBook("bookYear");
			System.out.print("수정할 책 년도->");
		}else if(editField.equals("3")) {
			vo.setFieldBook("bookPublisher");
			System.out.print("수정할 출판사->");
		}
		vo.setBookPrice(scan.nextLine());
	
		BookDAO dao = BookDAO.getInstance();
		int cnt = dao.bookUpdate(vo); // 필드네임, 수정할 값 3개가 들어가 있다. 
		if(cnt>0) {
			System.out.println(vo.getBookPrice()+"으로 수정되었습니다.");
		}else {
			System.out.println("수정에 실패하였습니다.");
		}		
	}
	
	//책목록
	public void bookAdd() {

		BookVO vo = new BookVO();
		
		System.out.print("책코드->");
		vo.setBookCode(Integer.parseInt(scan.nextLine()));
		
		System.out.print("책이름->");
		vo.setBookName(scan.nextLine());
		
		System.out.print("작가");
		vo.setBookAuthor(scan.nextLine());
		
		System.out.print("출판사");
		vo.setBookPublisher(scan.nextLine());

		System.out.print("가격->");
		vo.setBookPrice(scan.nextLine());
		
		System.out.print("출판년도->");
		vo.setBookYear(scan.nextLine());
		
		BookDAO dao = new BookDAO();
		int cnt = dao.bookInsert(vo);
		if(cnt>0) {
			System.out.println(vo.getBookName()+"이 등록되었습니다.");
		}else {
			System.out.println("책 등록에 실패하였습니다.");
		}
	}
	
	//종료
	public void bookClose() {
		System.exit(0);
	}
	
	//메뉴
	public String menuShow() {
		System.out.print("[1.책 목록, 2.등록, 3.수정, 4.삭제, 5.종료, 6.검색]");
		//메뉴 입력
		return scan.nextLine();
	}
	
	public static void main(String[] args) {
		new BookStart();

	}

}
