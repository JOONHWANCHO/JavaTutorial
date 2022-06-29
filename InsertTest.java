package mysql_jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class InsertTest {
	Connection conn=null;
	PreparedStatement pstmt = null;
	Scanner scan = new Scanner(System.in);
	
	public InsertTest() {
		// TODO Auto-generated constructor stub
	}
	public void start() {
		//1.여기서 시작한다.
		//connector build path
		try {
		//1.Driver 로딩
		//Class 라느 클래쓰가 있다.
		Class.forName("com.mysql.cj.jdbc.Driver");// com.mysql.cj.jdbc.Driver로 찾아가서 자바가상 머신위에 올려준다.
		
		//2.DB연결   ip: 127.0.0.01  port:3307 / database:multi
		String url ="jdbc:mysql://@127.0.0.1/multi";
		conn = DriverManager.getConnection(url, "root", "root1234");
		//DB 접속 끝
		//데이터 준비
		System.out.print("회원번호->");
		int mem_id = Integer.parseInt(scan.nextLine());
		System.out.print("회원명->");
		String username = scan.nextLine();
		System.out.print("부서명");
		String depart = scan.nextLine();
		System.out.print("연락처->");
		String phone = scan.nextLine();
		System.out.print("이메일->");
		String email = scan.nextLine();
		
		
		//3. PreparedSattement 객체를 생성(sql 쿼리문) -> 데이터 세팅 
			String sql = "insert into member(mem_id, username, depart, phone, email)"
			        + "values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			//1번쨰 물음표 부터 시작
			pstmt.setInt(1, mem_id);
			pstmt.setString(2, username);
			pstmt.setString(3, depart);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			
		// 4. 실행
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("레코드가 추가되었습니다.");
			}else {
				System.out.println("레코드 추가 실패하였습니다.");
			}
			
		}catch(ClassNotFoundException cnfe) {
			System.out.println("드라이브로딩 실패....");
			cnfe.printStackTrace();
		}catch(SQLException se) {
			System.out.println("DB연결 실패.....");
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			//5.DB연결 해제
			//객체가 만들어졌는 확인하고 
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new InsertTest().start();

	}

}
