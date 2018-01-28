import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

class ServerListenThread implements Runnable {
	private Socket cs;

	public ServerListenThread(Socket clientSocket) {
		cs = clientSocket;
	}

	public void run() {
		String indata = "nobreak";
		DataInputStream in;
		DataOutputStream out;
		String StrPainter;

		try {
			if (cs.isConnected()) {
				System.out.println("Connection from client IP: " +
						cs.getInetAddress().getHostAddress() + "\n");
				in = new DataInputStream(cs.getInputStream());
				out = new DataOutputStream(cs.getOutputStream());

				while (true) {
					StrPainter = in.readUTF();
					System.out.println("StrPainter = " + StrPainter);
					for (Socket s : ServerTest.ClientList) {
						out = new DataOutputStream(s.getOutputStream());
						out.writeUTF(StrPainter);
					} // end for
					if (indata.equals("hi"))
						break;
				}
				in.close();
				out.close();
				cs.close();
			}
		} catch (EOFException eof) {
			eof.printStackTrace();
			System.exit(1);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
	}
}