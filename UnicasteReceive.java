package basic08_net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicasteReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	public UnicasteReceive() {
		try {
			//정보 받는 곳
			ds = new DatagramSocket(12000);
			// 512 byte 
			byte data[] = new byte[512];
			dp = new DatagramPacket(data, data.length);
			System.out.println("받기 대기중...");
			ds.receive(dp);
			
			//전송 받은 데이터 출력하기 
			byte[] receiveData = dp.getData();
			System.out.println(new String(receiveData, 0, dp.getLength()));//전송받은 바이트수 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicasteReceive();

	}

}
