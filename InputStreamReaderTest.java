package basic06_io;

import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		
	}
	public void start() {
		//InputStreamReader : 문자 단위 입력하는 클래스 
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			/*
			while(true) {
				int readData = isr.read();
				if(readData == -1) break;
				System.out.println(readData);
			}
			*/
			char[] inData = new char[10];
			int cnt 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InputStreamReaderTest().start();

	}

}
