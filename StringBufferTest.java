package basic02_api;

public class StringBufferTest {

	public static void main(String[] args) {
		// String : 연산이 적은 데이터 스레드 가능 
		// StringBuffer : 연산이 많고 쓰레드(동기화) 가능 
		// StringBuilder : 연산이 많고, 동기화를 고려하지 않을때

		//StringBuffer sb = new StringBuffer(30);
		StringBuffer sb = new StringBuffer("JAVA Programming Test..............");
		sb.append("잘되나?"); //마지막에 문자 추가, sb = sb.append("fdf");
		sb.insert(4, "(자바)");//문자열을 삽입 
		//012345   67890
		//JAVA(자바) Programing Test...........잘되나?
		//JAVA(Programing Test...........잘되나?
		sb.delete(5, 10);//문자열 지우기 
		//문자열 지우기
		System.out.println(sb);
		
		//sb.reverse();
		//System.out.println(sb);
		//확보한 메모리 확인 
		System.out.println("capacity->" + sb.capacity());
		
		StringBuffer first = new StringBuffer("Test");
		StringBuffer second = new StringBuffer("JAVA");
		
		//equals();
		//compareTo() : 문자와 문자를 비교하여 점수를 리턴해준다. 
		int result = first.compareTo(second);
		int result2 = second.compareTo(first);
		System.out.println("result->" + result+", result2->" + result2);
		
		// 0 : 두 객체의 데이터는 같다. 
		// 양수 : 왼쪽객체의 데이터가 크다. 
		// 음수 : 왼쪽객체의 데이터가 작다. 
		
	}

}
