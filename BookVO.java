package java_report_book;

public class BookVO {
	//필요한 변수 선언, 멤버테이블에 있는 변수는 일차적으로 다 선언
	//접근제한자는 private으로 선언
	//컬렉션 객체들을 하나로묶는것 
	//묶어줬기 때문에 리턴 가능하다
	//컬렉션에서 저장된 순서 유지 ArrayList, LinkedList
	//VO에서 게터와 세터를 만들어 주는 이
	
	private int bookCode;
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private String bookPrice;
	private String bookYear;
	
	private String fieldBook;
	
	
	public BookVO() {
	}


	public int getBookCode() {
		return bookCode;
	}


	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public String getBookPublisher() {
		return bookPublisher;
	}


	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}


	public String getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}


	public String getBookYear() {
		return bookYear;
	}


	public void setBookYear(String bookYear) {
		this.bookYear = bookYear;
	}


	public String getFieldBook() {
		return fieldBook;
	}


	public void setFieldBook(String fieldBook) {
		this.fieldBook = fieldBook;
	}
	

}
