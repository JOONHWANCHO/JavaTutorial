public class IfEx01 {
  public static void main(String[] args) {

      Scanner scan = new Scanner(System.in);

      System.out.print("금액입력=");
      int money = scan.nextInt();

      //조건식의 값이 참일떄 실행문을 실행한다.

      if(money>=10000) {
      int result = money / 10 * 10;
      System.out.println("result="+result);
      }

      System.out.println("end.....");

  }
}

    /*
      if문사용하기
      입력받은 값이 10,000이상일때만 마지막자리값을 0으로 바꿔서 출력하라.

      실행
      금액입력 = 26,315
      결과 = 26,310

      금액입력 = 568,259
    */

