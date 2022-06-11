import java.lang.System;
import java.util.Scanner;

public class ScannerTest {
  public static void main(String[] args) {
  
	//실행중 콘솔에 데이터를 입력받아 처리한다.
    //정수, 실수, 논리, 문자열 1 "100"
    //New : 객체생성(클래스를 이용하여)
    
    Scanner scan = new Scanner(System.in);
    
    // 정수: nextInt(). 실수: nextDouble(), 문자열 : nextLine()
    
    System.out.print("이름=");
    String name = scan.nextLine();
    System.out.print(name);
    
    System.out.print("국어=");
    int kor = scan.nextInt();
    System.out.println("kor="+ (kor/2));
    
    System.out.print("수학(실수)=");
    double math = scan.nextDouble(); // 95.23
    System.out.println("math=" + (math+100));
        
  }
}