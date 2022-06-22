package basic08_net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UnicasteSend {
	DatagramSocket ds;
	DatagramPacket dp;
	InetAddress ia; //192.168.0.38 맥북 아이피주소
	public UnicasteSend() {
		String str = "Spring Framework, 스프링프레임워크";
		try {
			//정보 보내는 곳
			ds = new DatagramSocket();
			//udp 방식의 정보를 보낼경우 DatagramPacket을 생성하여 전송한다.
			byte[] data = str.getBytes();
			ia = InetAddress.getByName("192.168.0.38");
			//처음에 들어온게 보낼데이터, 받는 컴
			dp = new DatagramPacket(data, 0, data.length, ia, 12000);
			//전송하기 
			ds.send(dp);
			
			System.out.println("전송완료--- 보내기");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicasteSend();

	}

}
