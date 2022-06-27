package basic05_collection;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Lotto {

	public static void main(String[] args) {
		//로또번호 생성기
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		//로또번호 생성기
		
		do {
			//게임수 입력
			System.out.print("게임수=");
			int cnt = scan.nextInt();

			/*1번재 풀이 컬렉션을 이용한 방법
			for(int i=1; i <= cnt; i++) {// 1, 22, 3, 4, 5.....cnt
				//게임이 만들어 진다. 
				int lotto[] = new int[7]; //로또번호 + 보너스
				//난수가 겹치는지 확인수 숫자 생성	
				
				for(int j=0; j<lotto.length; j++) {// 0, 1, 2, 3, 4, 5, 6
					lotto[j] = random.nextInt(45) + 1;//번호생성 1~45
					//현재 번호 이전에 만들어진 번호와 현재 생성된 번호와 같은게 있는지 중복검사
					//
					for(int c=0; c<j; c++) {
						//j=1 c=0, 0번째 꺼랑 1번째꺼랑 같냐 
						if(lotto[j] == lotto[c]) {
							j--; // 1->0
							break;
						}
					}	
				}
				//System.out.println(Arrays.toString(lotto)); ->확인하기 위해서  프린트
				//게임 정령 (보너스는 정렬제외)
				Arrays.sort(lotto, 0, 6); // index가 0~6이전번호까지만 정렬된다.
				//System.out.println(Arrays.toString(lotto));
				System.out.println(i+"게임=" + Arrays.toString(Arrays.copyOfRange(lotto, 0, 6))+", bonus="+lotto[6]);
		
			}
			*/
			
			for(int i=1; i <= cnt; i++) {// 1,22,3,4,5,,,cnt
				TreeSet<Integer> lotto = new TreeSet<Integer>();//번호 7개 저장할 객
				int lastNum=0; //마지막으로 생성된 번호를 기억하기 위한 변수 
				while(lotto.size()<7) {
					//						 30-20+1    +20
					lastNum = random.nextInt(45-1+1)	+1; // 20~30 	30-20+1 = 11 	0~10+20 -> 20~30
					lotto.add(lastNum);
				
				}
				///마지막으로 만든 번호를 보너스로 사용하기 위해 컬렉션에 있는 마지막 번호를 지운다. 
				lotto.remove(lastNum);
				System.out.println(i+"게임="+lotto.toString()+", bonus="+lastNum);
			}
			
			System.out.print("계속하시겠습니까?(1.예, 2.아니오)");
			int qna = scan.nextInt();
			if(qna!=1)break;//1외의 값이 들어오면 프로그램 종료한다.
			
		}while(true);
		
	}

}
