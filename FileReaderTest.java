package basic06_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReaderTest {

	public FileReaderTest() {
		// 
	}
	public void start() {
		// C:/Users/apple/Desktop/Developer/github
		try {
			File f = new File("C:/Users/apple/Desktop/Developer/github/new.txt");
			FileReader fr = new FileReader(f);
			int cnt=0;
			/*
			while(true) {
				int inData = fr.read();
				if(inData==-1) break;
				System.out.print((char)inData);
				cnt++;
			}
			*/
			
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				String inData = br.readLine();
				if(inData == null) break;
				System.out.println(inData);	
				cnt++;
			}
			
			System.out.println("\nct="+cnt);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		new FileReaderTest().start();

	}

}