package java_report_book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO extends DBConn{

	public BookDAO() {
	}
	public static BookDAO getInstance() {
		//클래스를 객체로 만들어서 반환, getInstance는 객체로 만들어 주기 위해 사용 
		return new BookDAO();
	}
	//메소드 단위로, 데이터베이스 연동할때 사용 
	//데이터베이스 작업
	//Select를 작업 ResultSet안에 데이터 베이스에서 작업한 테이블이 있다.
	//책 목록
	public List<BookVO> bookSelect(String searchWord) {
		List<BookVO> list = new ArrayList<BookVO>();
		
		try {
			//1.먼저 DB에 연결
			getConn();
			
			sql = "select bookCode, bookName, bookAuthor, bookPublisher, bookPrice, bookYear from member";
			if(searchWord != null) {
				sql += " where bookname like? ";
			}
			sql += " order by bookCode ";
			
			pstmt = conn.prepareStatement(sql);
			
			if(searchWord != null) {
				pstmt.setString(1, "%"+searchWord+"%");
			}
			System.out.println(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//책을 VO에 담기 
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getInt(1));
				vo.setBookName(rs.getString(2));
				vo.setBookAuthor(rs.getString(3));
				vo.setBookPublisher(rs.getString(4));
				vo.setBookPrice(rs.getString(5));
				vo.setBookYear(rs.getString(6));
				
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return list;
	}
	
	//책 등록
	public int bookInsert(BookVO vo) {
		int result = 0;
		try {
			getConn();
			
			sql = "insert into member(bookCode, bookName, bookAuthor,"
					+ "bookPublisher, bookPrice, bookYear) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBookCode());
			pstmt.setString(2, vo.getBookName());
			pstmt.setString(3, vo.getBookAuthor());
			pstmt.setString(4, vo.getBookPublisher());
			pstmt.setString(5, vo.getBookPrice());
			pstmt.setString(6, vo.getBookYear());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	//책 수정
	public int bookUpdate(BookVO vo) {
		int result=0;
		try {
			getConn();
			sql = "update member set "+vo.getFieldBook()+"=? where bookCode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, vo.getBookCode());
			pstmt.setString(1, vo.getBookPrice());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
	}
	
	//책 삭제
	public int bookDelete(int bookCode) {
		int result =0;
		try {
			getConn();
			sql = "delete from member where bookCode=?";
			pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, bookCode);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
