package employeesOOP;

import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DBConn{

	public EmpDAO() {
		
		
	}
	public static EmpDAO getInstance() {//클래스를 객체로 만들어서 반환, getInstance는 객체로 만들어 주기 위해 사용 
		return new EmpDAO();
	}
	//메소드 단위로, 데이터베이스 연동할때 사용 
	//데이터베이스 작업
	//Select를 작업 ResultSet -<안에 데이터 베이스에서 작업한 테이블이 있다.
	
	//회원목록
	public List<EmpVO> empSelect(String searchWord) { // list를 리턴
		//Arraylist
		List<EmpVO> list = new ArrayList<EmpVO>();
		
		try {
			//1.제일 먼저 DB 연결해야한다. 
			getConn();
			
			sql = "select mem_id, username, depart, phone, email from member"; 
			if(searchWord != null) {
				sql += " where username like ? ";
			}
			sql += " order by mem_id ";
			
			//select mem_id, username, depart, phone, email from member order by mem_id;
			//select mem_id, username, depart, phone, email from member where username='' order by mem_id;

			pstmt = conn.prepareStatement(sql);
			
			if(searchWord != null) {
				pstmt.setString(1, "%"+searchWord+"%");
			}
			System.out.println(sql);
			////////////////////////////
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//회원을 VO에 담기
				EmpVO vo = new EmpVO();
				vo.setMem_id(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setDepart(rs.getString(3));
				vo.setPhone(rs.getString(4));
				vo.setEmail(rs.getString(5));
				//VO를 Arraylist에 담기 | Arraylist라는 컬렉션이 필요하다.
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return list;
	}
	//회원등록
	public int empInsert(EmpVO vo) {//가운데는 반환형 int
		int result = 0;
		try {
			getConn();
			
			//sql = "insert into " 여기서 스페이스바로 한깐을 떨어뜨려줘야 한다. 
			//" member(mem_id, username, depart," // ,때문에 자동으로 구분이 된다.
			//+ "phone, meail) values(?,?,?,?,?)"; // 이거 쿼리 문이다.오라클에서 사용 
			
			sql = "insert into member(mem_id, username, depart," // ,때문에 자동으로 구분이 된다.
			+ "phone, email) values(?,?,?,?,?)"; // 이거 쿼리 문이다.오라클에서 사용 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMem_id());
			pstmt.setString(2, vo.getUsername());
			pstmt.setString(3, vo.getDepart());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getEmail());
			
			result = pstmt.executeUpdate();//실험 결과를 담고
			
		}catch(Exception e) {
			System.out.println(e.getMessage());//에러 정보 표시
		}
		return result;// 실행 결과를 리턴
	}
	
	//회원수정
	public 	int empUpdate(EmpVO vo) {
		int result=0;
		try {
			getConn();
			sql = "update member set "+vo.getFieldName()+"=? where mem_id=?"; // set 뒤에 공백을 넣어야 한다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPhone());
			pstmt.setInt(2, vo.getMem_id());
			
			result = pstmt.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
	}
	
	//회원삭제
	public int empDelete(int mem_id) {
		int result =0;
		try {
			getConn();
			sql = "delete from member where mem_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_id);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
