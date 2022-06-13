package com.example;

public class ArrayBubbleSort {

	public static void main(String[] args) {
		// 배열의 값을 크기순으로 정렬하기 
		
		int arr[] = {56,84,61,15,3,78,95,42};
		
		//정렬전
		
		System.out.print("정렬전->");
		for(int i=0; i<arr.length; i++) {//0,1,2,3,4,5,6,7
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		
		//루프돌리기 
		
		for(int j=0; j<arr.length-1; j++) {// 0,1,2,3,4,5,6
		
			//정렬	8-1-0	8-1-1	8-1-2
			for(int i=0; i<arr.length-1; i++) {//0,1,2,3,4,5,6
				if(arr[i] > arr[i+1]) {// 0번쨰 값과 1번쨰 값과 비교하여 0번쨰 값이 더 크면 교환한다.
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp; // 이렇게 하면 두개의 값이 변한다. 1번 바뀐거다. 
				}
			}
		
		//정렬후
			System.out.print("정렬후->\t");
			for(int i=0; i<arr.length; i++) {//0,1,2,3,4,5,6,7
				System.out.print(arr[i]+"\t");
			}
			System.out.println();
			
			
		}
		
	}

}
