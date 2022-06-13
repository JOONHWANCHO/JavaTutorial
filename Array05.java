package com.example;

public class Array05 {

	public static void main(String[] args) {
		// 2차원 배열의 초기값 설정 
		int jumsu[][] = new int [][] {{8,9,3},
									  {90,73,81},
									  {50,9,80}};
		int data[][] = {{90,50,60},
						{50,50,60},
						{90,80,70},
						{80,90,50}};
	
		//System.out.println("국어\t영어\t수학\t총점\t평균");
		
		String title[] = {"국어","영어","수학","총점","평균"};
		//확정된 반복문
		// 데이터타입 변수 : 배열, 컬렉션 
		for(String t : title) {
			System.out.print(t+"\t");
		}
		System.out.println();
		
		for(int row=0; row<data.length; row++) {
			
			int tot = 0;
			for(int col=0; col<data[row].length; col++) {
				System.out.print(data[row][col]+"\t");
				tot += data[row][col];
			}
			
			//평균 
			//tot/data[row].length;
			int ave = tot/3;
			System.out.print(tot+"\t"+ave);
			
			System.out.println();
		}
		
	}

}
