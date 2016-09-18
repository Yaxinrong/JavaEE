import java.io.*;
import java.net.*;

class Server extends Thread {

	Socket clientRequest; // �û����ӵ�ͨ���׽���
	BufferedReader input; // ������
	PrintWriter output; // �����

	public Server(Socket s) { // serverThread�Ĺ�����
		this.clientRequest = s; // ����receiveServer�������׽���
		InputStreamReader reader;
		OutputStreamWriter writer;
		try { // ��ʼ�����롢�����
			reader = new InputStreamReader(clientRequest.getInputStream());
			writer = new OutputStreamWriter(clientRequest.getOutputStream());
			input = new BufferedReader(reader);
			output = new PrintWriter(writer, true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void run() { // �̵߳�ִ�з���
		String str = null;

			try {
				str = input.readLine(); // ���տͻ���ָ��
				StringBuffer buffer = new StringBuffer(str);
				buffer.reverse();
				output.print(buffer.toString());
				output.flush();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		try {
			clientRequest.close(); // �ر��׽���
			input.close();
			output.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		str = null;
	}// end of run
}