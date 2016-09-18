import java.io.*;
import java.util.*;
import java.net.*;

public class Recieve {
	final int RECEIVE_PORT = 3333; // 该服务器的端口号
	final String SERVER_IP = "127.0.0.1";

	// receiveServer的构造器
	public Recieve() {
		ServerSocket rServer = null; // ServerSocket的实例
		Socket request = null; // 用户请求的套接字
		Thread receive = null;
		try {
			rServer = new ServerSocket(RECEIVE_PORT,10,InetAddress.getByName(SERVER_IP)); // 初始化ServerSocket
			//System.out.println("Welcome to the server!");
			//System.out.println(new Date());
			//System.out.println("The server is ready!");
			//System.out.println("Port: " + RECEIVE_PORT);
			while (true) { // 等待用户请求
				request = rServer.accept(); // 接收客户机连接请求
				receive = new Server(request); // 生成serverThread的实例
				receive.start();// 启动serverThread线程
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String args[]) {
		new Recieve();
	} // end of main

} // end of class