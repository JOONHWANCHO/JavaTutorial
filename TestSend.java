import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestSend {
	DatagramSocket ds;
	DatagramPacket dp;
	InetAddress ia;
	final int PORT=21000;
	public TestSend() {
		
	}
	public void sendStart() {
		try {
			ds=new DatagramSocket();
			ia=InetAddress.getByName("192.168.0.4");
			
			//ÆÄÀÏÀÇ ³»¿ë¸£ byte¹è¿­·Î ÀÐ¾î¿Í Àü¼ÛÇÏ±â À§ÇØ InputStream °´Ã¤¸¦ »ý¼ºÇÑ´Ù.
			File f=new File("/Users/apple/Desktop/img/02.PNG");
			try (FileInputStream fis = new FileInputStream(f)) {
				//ÆÄÀÏ¸íÀ» Àü¼Û
				String sendFileName="[*$@File&]"+f.getName();//"[*$@File&]02/jpg"
				dp=new DatagramPacket(sendFileName.getBytes(),0,sendFileName.getBytes().length,ia,PORT);
				ds.send(dp);
				
				//ÆÄÀÏ³»¿ëÀÐ¾î Àü¼Û
				int cnt=0;
				while(true) {
					byte[]b=new byte[512];
					int byteCount=fis.read(b,0,b.length);
					System.out.println(++cnt+ ", byte=" +byteCount);
					if(byteCount<=0)break;
					dp=new DatagramPacket(b,0,byteCount,ia,PORT);
					ds.send(dp);
				}
			}
			
			//Àü¼ÛÀ» ¿Ï·á..
			String endMessage="[*%%$end4]";
			dp=new DatagramPacket(endMessage.getBytes(),0,endMessage.getBytes().length,ia,PORT);
			ds.send(dp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new TestSend().sendStart();

	}

}
