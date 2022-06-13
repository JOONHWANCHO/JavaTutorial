package com.example;

import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		//제목을 배열에 저장
		String title[] = {"국어","과학", "영어", "수학", "물리", "지구과학"};
		int jumsu[] = new int[title.length]; //국어, 영어, 수학, 물리
	
		for(int i=0; i<title.length; i++) {//0,1,2,3
			System.out.print(title[i]+"점수=");
			jumsu[i] = scan.nextInt();
		}
		
		//총점
		int tot=0;
		for(int i=0; i<jumsu.length; i++) {
			tot += jumsu[i];
		}
		//평균
		int ave = tot / title.length;
	
		System.out.println("총점=" +tot);
		System.out.println("평균=" +ave);
	}

}

/*

90-100 A
80-89 B
70-79 C
60-69 D
0-59 F

실행결과
국어점수=80
영어점수=90
수학점수=80

총점=250
평균=
학점=B
 */