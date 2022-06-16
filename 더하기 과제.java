public class summation_of_arithmetic_progression {
	public static void main(String[] args) {
		
		int totalSum = 0;
		int oddSum = 0;
		int evenSum = 0;
		
		for(int i = 0; i < 100; i++) {
			totalSum = totalSum + (i + 1);
		}
		
		System.out.println("1부터 100까지의 숫자의 합은 " + totalSum + " 입니다.\n");
		
		
		for(int i = 0; i < 100; i++) {
			if ((i + 1) % 2 != 0) {
				oddSum = oddSum + (i + 1);
			}
		}
		
		System.out.println("1부터 100까지의 홀수의 합은 " + oddSum + " 입니다.\n");
		
		for(int i = 0; i < 100; i++) {
			if ((i + 1) % 2 == 0) {
				evenSum = evenSum + (i + 1);
			}
		}
		
		System.out.println("1부터 100까지의 짝수의 합은 " + evenSum + " 입니다.\n");
	}
}

결과 : 

1부터 100까지의 숫자의 합은 5050 입니다.

1부터 100까지의 홀수의 합은 2500 입니다.

1부터 100까지의 짝수의 합은 2550 입니다.

/*
6월 9일 목요일까지 과제
실행
임의의 정수=100
1-100까지의 합은 5050
1-100까지의 홀수의 합은 2500
1-100까지의 짝수의 합은 2550 
 */

