package basic05_collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
		// TODO Auto-generated constructor stub
	}
	public void start() {
		//TreeMap : key의 value를 이용하여 컬렉션을 사용한다.
		//			key를 기준으로 정렬을 해준다. 
		TreeMap<String, MemberVO> tm = new TreeMap<String, MemberVO>();
		
		tm.put("1", new MemberVO(1000, "홍길동", "총괄부", "010-1111-2222"));
		tm.put("A", new MemberVO(2000, "홍길동2", "총괄부", "010-1111-9999"));
		tm.put("김길동", new MemberVO(3000, "홍길동3", "총괄부", "010-1111-4444"));
		tm.put("B", new MemberVO(4000, "홍길동4", "총괄부", "010-1111-8888"));
		tm.put("100", new MemberVO(5000, "홍길동5", "총괄부", "010-1111-3333"));
	
		Set<String> keys = tm.keySet();
		Iterator<String> keyList = keys.iterator();
		while(keyList.hasNext()) {
			String key = keyList.next();
			MemberVO vo = tm.get(key);
			System.out.println(key+"->"+vo.toString());
		}
	
	}
	public static void main(String[] args) {
		new TreeMapTest().start();		
	}

}
