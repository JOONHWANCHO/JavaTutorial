import

public class VariableEx2 {
  public static void main(String[] args) {

  	/*
		임의의 점수를 입력받아 1~100사이의 값이면, 입력받은 
		받은 값에 100를 곱하여 출력하고, 그외의 값은 0을 출력하라.
  	*/
  
  	Scanner s = new Scanner(System.in);
	//데이터
  	int num = s.nextInt();
	//계산(변수를 다시 선언할 필요가 없다)
  	num=(num>=1 && num<=100) ? num*10 : 0 ;
	//출력
  	System.out.println(num);



	Scanner inData = new Scanner(System.in);

  	System.out.print("점수=")
    int randomNum = inData.nextInt();
    
    int count = (randomNum>0 && randomNum < 101)? number * 100 : 0;

    System.out.println("출력값:" + randomNum);	
   
  }
}