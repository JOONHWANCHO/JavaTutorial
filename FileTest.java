package basic06_io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		
	}
	public void start() {
		//드라이브, 폴더, 파일에 관한 정보를 사용하기 위해서는 File객체를 만들어야 합니다. 
		/*
			File(File parent, String child)
			File(String parent, String child)
			
			File(String pathname)
		 */
		
		try {
		
		File f1 = new File("C://");		//	\->제어분자 \n \t"
		File f2 = new File("c://dev");
		File f3 = new File("c://Test.java");
		
		File f4 = new File(f2, "Test.java");
		File f5 = new File("c:/dev","Test.java");
		
		//경로 또는 파일의 존재 유무, 있으면 true, 없으면 false가 구해진다.
		System.out.println(f2.exists());
		System.out.println(f3.exists());
		//폴더 생성
		if(!f2.exists()) {
			//mkdir(), mkdirs() : 부모폴더 생성 
				if(f2.mkdirs()) {
					System.out.println("폴더가 생성되었습니다.");
				}else {
					System.out.println("폴더생성 실패하였습니다.");
				}
				
		}
		//파일생성
		if(!f4.exists()) {
			if(f4.createNewFile()) {//생true, 실패false
				System.out.println("파일생성됨");
			}else {
				System.out.println("파일생성못함");
			}
		}
		//마지막 수정날짜
		long lastDate = f3.lastModified();
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(lastDate);
		//2022-5-30 오후 3:57
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		String lastDateStr = fmt.format(date.getTime());
		System.out.println("마지막수정일->"+lastDate);
		
		//특정드라이브에 있는 폴더와 파일목록을 구한다.
		File[] files = f1.listFiles();
		
		// getName() : 파일명
		// getParent() : 드라이브명 + 폴더
		// getPath(), getAbsolutePath() : 드라이브명 + 폴더 + 파일명
		
		for(File f : files) {
			if(f.isDirectory()) {//디렉토리인지 확인 
				System.out.println(f.getPath()+"[폴더]");
			}else if(f.isFile()) {//파일인지 확인 
				System.out.println(f.getPath()+"[파일]");
			}if(f.isHidden()) {
				System.out.println(f.getPath()+"[숨김파일]");
				
			}else {
				System.out.println(f.getPath()+"[파일]");
			}
		}
		
		//드라이브 목록 
		File drive[] = File.listRoots();
		for(File f:drive) {
			System.out.println(f.getPath());
		}
		
		//파일의 크기 (byte)
		long fileSize = f3.length();
		System.out.println("fileSize->" + fileSize);
		
		//파일삭제 
		boolean boo = f3.delete();
		System.out.println(boo);
		
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		new FileTest().start();

	}

}
