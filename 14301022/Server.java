import java.io.*;
import java.net.*;

class Server extends Thread {

	Socket clientRequest; // 用户连接的通信套接字
	BufferedReader input; // 输入流
	PrintWriter output; // 输出流

	public Server(Socket s) { // serverThread的构造器
		this.clientRequest = s; // 接收receiveServer传来的套接字
		InputStreamReader reader;
		OutputStreamWriter writer;
		try { // 初始化输入、输出流
			reader = new InputStreamReader(clientRequest.getInputStream());
			writer = new OutputStreamWriter(clientRequest.getOutputStream());
			input = new BufferedReader(reader);
			output = new PrintWriter(writer, true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void run() { // 线程的执行方法
		String str = null;

			try {
				str = input.readLine(); // 接收客户机指令
				StringBuffer buffer = new StringBuffer(str);
				buffer.reverse();
				output.print(buffer.toString());
				output.flush();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		try {
			clientRequest.close(); // 关闭套接字
			input.close();
			output.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		str = null;
	}// end of run
}