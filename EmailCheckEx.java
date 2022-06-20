package basic02_api;

import java.util.Scanner;
import java.util.StringTokenizer;

public class EmailCheckEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.print("이메일=");
			String email = scan.nextLine();
			//@이가 있어야 한다, .이 있어야 한다., @있는 함수 찾기
			int atMark = email.indexOf("@");
			int point = email.indexOf("."); // sdfsdf@.natecom
			
			if(atMark < 3 || point < atMark || Math.abs(atMark-point) <= 2) {//잘못된 이메일 찾기
				System.out.println(email+"은 잘못된 메일입니다.");
			}else {//정상이메일 일때
				//split(), substring(), StringTokenizer 
				
				/*1.Split
				String emailSplit []= email.split("@");
				System.out.println("아이디=" + emailSplit[0]);
				System.out.println("도메인=" + emailSplit[1]);
				*/
				
				/*2.Substring()
				
				String id = email.substring(0, atMark);
				String domain = email.substring(atMark+1);
				System.out.println("id=" + id);
				System.out.println("domain=" + domain);
				*/
				
				//StringTokenizer
				StringTokenizer emailObj = new StringTokenizer(email, "@");
				String id = emailObj.nextToken();
				String domain = emailObj.nextToken();
				System.out.println("아이디=" + id);
				System.out.println("도메인" + domain);
				
			}
			System.out.println("계속하시겠습니까(y:예, n:아니오)?");
			//String q = scan.nextLine();
			if(!scan.nextLine().equalsIgnoreCase("y")) {
				System.out.println("The End.....");
				break;
			}
			
		}while(true);
		
		
	}

}
/*
실행

이메일=fjfkdjfkd@nate.com
아이디=fjfkdjfkd
도메인=nate.com
다시하시겠습니까(y.예, n.아니오)?y

이메일=addd.@com
잘못된 이메일주소입니다.

다시하시겠습니까(y.예, n.아니오)?1
 */

/*내가 한것 
		//scanner
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이메일=");
		
		String data = scan.next();
		
		String[] ArraysStr = data.split("@");
		
		System.out.println("아이디=" + data);
		System.out.println("도메인=" + data);
		
		
		//Split -> 쪼개서 1번쨰거, 2번쨰거 담는걸 못하겠다.

		//다시 반복해서 입력 하게 하는걸 모르겠.
		
		//잘못된 이메일 주소
		if(data2 = .com) {

		}else {
			System.out.println("잘못된 이메일 주소 입니다.");
			
			int redata = scan.nextInt();
			System.out.println("다시하시겠습니까?(1.예, 2.아니오)");
			
			String data = scan.next();
			System.out.println("이메일=");
		}
 내가한것 끝*/