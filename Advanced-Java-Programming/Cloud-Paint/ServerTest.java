import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerTest {
	private ServerSocket ss;
	private Socket cs;
	private static final int port = 57968;
	private static final int backlog = 10;
	private static final String addr = "127.0.0.1";
	public static ArrayList<Socket> ClientList = new ArrayList<Socket>();

	public ServerTest() {
		buildServerSocket();
		waitForClients();
		closeSocket();
	}

	private void buildServerSocket() {
		try {
			ss = new ServerSocket(port, backlog, InetAddress.getByName(addr));
			//build socket
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private void waitForClients() {
		System.out.println("Wait for clients...");
		while (true) {
			try {
				cs = ss.accept();
				ClientList.add(cs);
				System.out.println("Client Connected!");
				Thread thread = new Thread(new ServerListenThread(cs));
				thread.start();
				//Create a thread for every Client
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	private void closeSocket() {
		try {
			cs.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		System.out.println("I'm Server!!!!");
		new ServerTest();
	}
}