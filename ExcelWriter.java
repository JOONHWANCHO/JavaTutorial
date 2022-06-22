import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 Excel로 내용을 읽기쓰기를 하기위해서는 framework가 필요하다.
 
 1. POI 다운로드 
 
 jakarta.apache.org에서 왼쪽카테고리에서 POI를 선
 
 -> downloads -> poi-bin-5.2.2-20220312.zip를 다운받는다. 
 
 Build Path -> 프로젝트에서 마우스 오른쪽 키
 	poi-5.2.2.jar
 	commons-math3-3.6.1.jar
 	
 2. Logging 다운로드 
 jakarta.apache.org에서 logging -> Apache Log4j 2 -> apache-log4j-2.17.2-bin.zip ->
 
 */

public class ExcelWriter {

	public ExcelWriter() {
		//엑셀로 쓰기
		//1. workbook 생성
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//2. sheet 생성
		HSSFSheet sheet1 = workbook.createSheet("회원목록");
		HSSFSheet sheet2 = workbook.createSheet();
		
		//3. row생성 
		HSSFRow row0 = sheet1.createRow(0);//0행 생성 
		
		//4.cell 생성
		HSSFCell cell0 = row0.createCell(0);
		cell0.setCellValue("번호");
		
		row0.createCell(1).setCellValue("이름");
		row0.createCell(2).setCellValue("연락처");
		
		HSSFRow row1 = sheet1.createRow(1);
		row1.createCell(0).setCellValue(1);
		row1.createCell(1).setCellValue("홍길동");
		row1.createCell(2).setCellValue("010-1234-5678");
		
		HSSFRow row2 = sheet1.createRow(2);
		row2.createCell(0).setCellValue(2);
		row2.createCell(1).setCellValue("이순신");
		row2.createCell(2).setCellValue("010-1111-2222");
		
		HSSFRow row3 = sheet1.createRow(3);
		row3.createCell(0).setCellValue(3);
		row3.createCell(1).setCellValue("세종대왕");
		row3.createCell(2).setCellValue("010-7777-2222");
		
		//파일로 쓰기
		try {
			File f = new File("/Users/apple/Desktop/TestFolder/member.xls");
			FileOutputStream fos = new FileOutputStream(f);
			workbook.write(fos);
		}catch(FileNotFoundException e) {
			System.out.println("파일이 없을떄->" + e.getMessage());
		}catch(IOException ie) {
			System.out.println("입출력예외->"+ ie.getMessage());
		}
		System.out.println("excel write완료...");
	}

	public static void main(String[] args) {
		new ExcelWriter();

	}

}
