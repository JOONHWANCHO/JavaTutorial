import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	FileOutputStream fos;
	public TestReceive() {
		
	}
	public void receiveStart() {
		try {
			ds=new DatagramSocket(21000);
			byte[] receiveData=new byte[512];
			dp=new DatagramPacket(receiveData,receiveData.length);
			while(true) {
				System.out.println("전송받기 대기중입니다...");
				ds.receive(dp);//Àü¼Û¹Þ±â
				
			byte[] receive=dp.getData();
			int byteCount=dp.getLength();//Àü¼Û¹ÞÀº byte ¼ö
			
			String receiveStr=new String(receive,0,byteCount);//[*$@File&]02/jpg
			if(byteCount>=10 && receiveStr.substring(0,10).equals("[*$@File&]")) {//ÆÄÀÏ¸íÀÌ Àü¼ÛµÇ¾ú´Ù.
				fos=new FileOutputStream(new File("/Users/apple/Desktop/TestFolder",receiveStr.substring(10)));
				System.out.println("파일생성됨...->"+receive);
			}else if(byteCount>=10 && receiveStr.equals("[*%%$end4")) {
				fos.close();
				ds.close();
				System.out.println("파일로 저장되었습니다...");
				break;
			}else {//ÆÄÀÏ³»¿ë
				fos.write(receive,0,byteCount);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TestReceive().receiveStart();

	}

}
