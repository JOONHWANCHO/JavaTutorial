package basic04_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest2 {
	Scanner scan = new Scanner(System.in);
	public ExceptionTest2() {
		start();
	}
	
	public void start() {
		
		System.out.print("첫밴째 정수=");
		int first = scan.nextInt();//InputMismatchException
		System.out.print("두번쨰 정수=");
		int second = scan.nextInt();
		
		System.out.printf("first=%d, second=%d\n", first, second);
		
		int result = first / second;// 어떤 수를 0으로 나눌 수 없다. ArithmeticException
		System.out.println(first+"/"+second+"="+result);
		
		int data[] = {7, 9, 2, 4, 8, 5};
		for(int i=0; i<= data.length; i++) {// 0, 1, 2, 3, 4, 5, 6
			
			System.out.println("data["+i+"]="+ data[i]);//ArrayIndexOutOfBoundsException
		}

	}catch(ArrayIndexOutOfBoundsException ae) {
		System.out.println("배열의 인덱스를 잘못하용하였습니다.");
	}catch(Exception e) {
		System.out.println("숫자를 다시 입력하세요.");
	}finally {
		
	}

	public static void main(String[] args) {
		new ExceptionTest2();
		
	}

}
