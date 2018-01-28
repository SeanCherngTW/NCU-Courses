import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

class ClientPaintListenThread implements Runnable {
	private Socket cs;

	public ClientPaintListenThread(Socket clientSocket) {
		cs = clientSocket;
	}

	public void run() {
		DataInputStream in;
		int x1, y1, x2, y2, tools, size, red, green, blue;
		float fSize;
		boolean fill;
		Color color;
		String StrPainter;
		String[] painterComponent;

		try {
			if (cs.isConnected()) {
				System.out.println("Listen Thread: " +
						cs.getInetAddress().getHostAddress() + "\n");
				in = new DataInputStream(cs.getInputStream());

				while (true) {
					StrPainter = in.readUTF();
					System.out.println("In ClientPaintListenThread: ");
					System.out.println(StrPainter);
					if (StrPainter.equals("clean")){
						CloudPaint.drawPanel.repaint();
						continue;
					}
					painterComponent = StrPainter.split(",");
					x1 = Integer.valueOf(painterComponent[0]);
					y1 = Integer.valueOf(painterComponent[1]);
					x2 = Integer.valueOf(painterComponent[2]);
					y2 = Integer.valueOf(painterComponent[3]);
					tools = Integer.valueOf(painterComponent[4]);
					size = Integer.valueOf(painterComponent[5]);
					fSize = (float) size * 3;
					fill = Boolean.parseBoolean(painterComponent[6]);
					red = Integer.valueOf(painterComponent[7]);
					green = Integer.valueOf(painterComponent[8]);
					blue = Integer.valueOf(painterComponent[9]);
					color = new Color(red,green,blue);
					Graphics g = CloudPaint.drawPanel.getGraphics();
					g.setColor(color);
					Graphics2D g2d = (Graphics2D) g;
					g2d.setStroke(new BasicStroke(fSize));
					g2d.setPaint(color);
					switch (tools) {
					case 0:
						g.fillOval(x1, y1, 10 * size, 10 * size);
						System.out.println("case 0 in ClientPaintListenThread");
						break;
					case 1://Line
						g2d.draw(new Line2D.Double(x1, y1, x2, y2));
						System.out.println("case 1 in ClientPaintListenThread");
						break;

					case 2://Oval
						if (fill)
							g2d.fill(new Ellipse2D.Double(Math.min(x1, x2), Math.min(y1, y2),
									Math.abs(x2 - x1),
									Math.abs(y2 - y1)));
						else
							g2d.draw(new Ellipse2D.Double(Math.min(x1, x2), Math.min(y1, y2),
									Math.abs(x2 - x1),
									Math.abs(y2 - y1)));
						System.out.println("case 2 in ClientPaintListenThread");
						break;

					case 3://Rectangle
						if (fill)
							g2d.fill(new Rectangle2D.Double(Math.min(x1, x2), Math.min(y1, y2),
									Math.abs(x2 - x1), Math.abs(y2 - y1)));
						else
							g2d.draw(new Rectangle2D.Double(Math.min(x1, x2), Math.min(y1, y2),
									Math.abs(x2 - x1), Math.abs(y2 - y1)));
						System.out.println("case 3 in ClientPaintListenThread");
						break;
					}
				}
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