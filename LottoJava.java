package com.example;

import java.util.Scanner;

public class lottoJava {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.print("게임수= ");
			int cycle = scan.nextInt();
			int[] arr = new int[7];
			int m = 0;
			while(cycle > 0) {
				for(int i = 0; i<arr.length;i++) {
					arr[i] = (int)(Math.random()*45)+1;
					for(int j=0; j<i;j++) {
						if(arr[i]==arr[j]) {
							i--;
						}
					}
				}
				for(int i=0; i<arr.length-1;i++) {
					System.out.printf("%5d", arr[i]);
				}
				System.out.printf("\t bonud = +%5d", arr[6]);
				System.out.println();
				cycle--;
				
			}

			//////////////////////////////
			System.out.print("계속하시겠습니까(1.예, 2.아니오?)");
			
			if(scan.nextInt() != 1) break; //1외의 같은 프로그램
			
		}while(true);
		
		System.out.println("프로그램이 종료 되었습니다.");
		
		
	}

}

/*
게임수를 입력받아 게임수만큼 로또 번호를 생성하여 아래와 같이 출력하라.
-중복번호 제거
-로또 번호는 오름차순으로 정렬
-보너스 번호 생
 */