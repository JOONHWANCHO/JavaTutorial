import java.util.Scanner;

public class VariableEx3 {
  public static void main(String[] args) {

  	/*

    사각형의 넓이 = 가로 * 세로
    사각형의 둘레 = (가로+세로)*2

		실행결과
    메뉴(1.사각형의 넓이, 2.사각형의 둘레) ? 1

    가로(밑변)=6
    세로(높이)=5
    사각형의 넓이 = 30

    ------------------
    메뉴(1.사각형의 넓이, 2.사각형의 둘레) ? 2

    가로(밑변)=6
    세로(높이)=5
    사각형의 넓이 = 22

  	*/
  
  	Scanner s = new Scanner(System.in);

    System.out.println("1.사각형의 넓이, 2.사각형의 둘레");
      int menu = s.nextInt();
    System.out.print("가로(밑변)=");
      int width = s.nextInt();
    System.out.print("세로(높이)=");
      int height = s.nextInt();

      int result = (menu==1) ? width * height : (width + height) * 2;

	//데이터
	//계산(변수를 다시 선언할 필요가 없다)
	//출력
  	System.out.println("사각형의" + ((menu==1) ? "넓이=" : "둘레=") + result);
   
  }
}