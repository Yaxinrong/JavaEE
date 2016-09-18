import java.io.*;
import java.util.*;
import java.net.*;

public class Recieve {
	final int RECEIVE_PORT = 3333; // �÷������Ķ˿ں�
	final String SERVER_IP = "127.0.0.1";

	// receiveServer�Ĺ�����
	public Recieve() {
		ServerSocket rServer = null; // ServerSocket��ʵ��
		Socket request = null; // �û�������׽���
		Thread receive = null;
		try {
			rServer = new ServerSocket(RECEIVE_PORT,10,InetAddress.getByName(SERVER_IP)); // ��ʼ��ServerSocket
			//System.out.println("Welcome to the server!");
			//System.out.println(new Date());
			//System.out.println("The server is ready!");
			//System.out.println("Port: " + RECEIVE_PORT);
			while (true) { // �ȴ��û�����
				request = rServer.accept(); // ���տͻ�����������
				receive = new Server(request); // ����serverThread��ʵ��
				receive.start();// ����serverThread�߳�
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String args[]) {
		new Recieve();
	} // end of main

} // end of class