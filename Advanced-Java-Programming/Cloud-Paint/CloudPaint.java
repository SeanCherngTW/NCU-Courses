import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class CloudPaint extends JFrame {
	private static final long serialVersionUID = 1L;
	//private static final String[] toolName =
	//{ "Brush", "Line", "Oval", "Rectangle" };
	private JPanel toolPanel, statusPanel;
	public static JPanel drawPanel;
	private JRadioButton BrushRB, LineRB, OvalRB, RectangleRB;
	private ButtonGroup toolsGroup;
	private JRadioButton brushSmallRB, brushMediumRB, brushBigRB;
	private ButtonGroup RBGroup;
	private JCheckBox fillChkB;
	private JButton clearButton, colorButton;
	private JLabel toolLabel, brushLabel, mouseLocLabel, otherLabel,
			toolStatusLabel, sizeStatusLabel, fillStatusLabel;
	public int tools = 0;
	public int size = 1;
	public float fSize = 1.0f;
	public boolean fill = false;
	public Color color;
	public static Socket cs;
	public static String ServerIP = "0";
	public static int ServerPort = 0;
	public static DataOutputStream out;
	public static DataInputStream in;

	// declare first so they can be used in inner classes

	public static void main(String[] args) {
		CloudPaint cloudPaint = new CloudPaint();
		cloudPaint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cloudPaint.setResizable(false);
		cloudPaint.setSize(800, 600);
		cloudPaint.setVisible(true);
	}

	public CloudPaint() {
		super("CloudPaint");
		/* Main Frame */
		drawPanel = new JPanel();
		toolPanel = new JPanel();
		statusPanel = new JPanel();
		setLayout(new BorderLayout());
		/* Main Frame */

		/* Menu Bar */
		JMenuBar menuBar = new JMenuBar();
		JMenu connectionMenu = new JMenu("Connection");
		JMenuItem connectItem = new JMenuItem("Connect");
		connectItem.setMnemonic('C');
		connectionMenu.add(connectItem);
		connectItem.addActionListener(new ConnectItemHandler());
		setJMenuBar(menuBar);
		menuBar.add(connectionMenu);
		/* Menu Bar */

		/* Tool Panel */
		toolLabel = new JLabel("[Tool]");
		BrushRB = new JRadioButton("Brush", true);
		LineRB = new JRadioButton("Line", false);
		OvalRB = new JRadioButton("Oval", false);
		RectangleRB = new JRadioButton("Rectangle", false);
		toolsGroup = new ButtonGroup();

		brushLabel = new JLabel("[Brush]");
		brushSmallRB = new JRadioButton("Small", true);// default
		brushMediumRB = new JRadioButton("Medium", false);
		brushBigRB = new JRadioButton("Big", false);
		RBGroup = new ButtonGroup();
		fillChkB = new JCheckBox("Fill");
		clearButton = new JButton("Clear");
		colorButton = new JButton("Color");
		//initialization

		toolsGroup.add(BrushRB);
		toolsGroup.add(LineRB);
		toolsGroup.add(OvalRB);
		toolsGroup.add(RectangleRB);

		RBGroup.add(brushSmallRB);
		RBGroup.add(brushMediumRB);
		RBGroup.add(brushBigRB);
		//set Radio Button Group

		toolPanel.add(toolLabel);
		toolPanel.add(BrushRB);
		toolPanel.add(LineRB);
		toolPanel.add(OvalRB);
		toolPanel.add(RectangleRB);
		toolPanel.add(brushLabel);
		toolPanel.add(brushSmallRB);
		toolPanel.add(brushMediumRB);
		toolPanel.add(brushBigRB);
		toolPanel.add(fillChkB);
		toolPanel.add(colorButton);
		toolPanel.add(clearButton);
		toolPanel.setLayout(new GridLayout(14, 1, 0, 0));
		// add components to panel

		clearButton.addActionListener(new ClearButtonHandler());
		colorButton.addActionListener(new ColorButtonHandler());
		BrushRB.addItemListener(new ToolHandler());
		LineRB.addItemListener(new ToolHandler());
		OvalRB.addItemListener(new ToolHandler());
		RectangleRB.addItemListener(new ToolHandler());

		brushSmallRB.addItemListener(new SizeHandler());
		brushMediumRB.addItemListener(new SizeHandler());
		brushBigRB.addItemListener(new SizeHandler());
		fillChkB.addItemListener(new FillHandler());
		//set Listener
		/* Tool Panel */

		/* Status Panel */
		mouseLocLabel = new JLabel("Mouse:");
		toolStatusLabel = new JLabel("Tool:Brush");
		sizeStatusLabel = new JLabel("Size:Small");
		fillStatusLabel = new JLabel("Fill:No");
		otherLabel = new JLabel("other status");
		statusPanel.add(mouseLocLabel);
		statusPanel.add(toolStatusLabel);
		statusPanel.add(sizeStatusLabel);
		statusPanel.add(fillStatusLabel);
		statusPanel.add(otherLabel);
		statusPanel.setLayout(new GridLayout(1, 3, 0, 0));
		/* Status Panel */

		/* Draw Panel */
		drawPanel = new DrawPanel();
		drawPanel.setBackground(Color.WHITE);
		/* Draw Panel */

		add(statusPanel, BorderLayout.SOUTH);
		add(toolPanel, BorderLayout.WEST);
		add(drawPanel, BorderLayout.CENTER);
	}//end constructor

	class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {
		private static final long serialVersionUID = 1L;

		int x1, x2, y1, y2;

		public DrawPanel() {
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}//end method

		@Override
		public void mouseClicked(MouseEvent event) {
		}

		@Override
		public void mousePressed(MouseEvent event) {
			x1 = event.getX();
			y1 = event.getY();
			mouseLocLabel
					.setText(String.format("Location:[%d,%d]", event.getX(), event.getY()));
			otherLabel.setText(String.format("Press at:[%d,%d]", event.getX(), event.getY()));
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			Graphics g = getGraphics();
			Graphics2D g2d = (Graphics2D) g;
			x2 = event.getX();
			y2 = event.getY();//End Point
			mouseLocLabel
					.setText(String.format("Location:(%d,%d)", event.getX(), event.getY()));
			otherLabel.setText(String.format("Release at:[%d,%d]", event.getX(), event.getY()));
			g2d.setStroke(new BasicStroke(fSize));
			g2d.setPaint(color);
			switch (tools) {
			case 0://Brush
				g.fillOval(x2, y2, 10 * size, 10 * size);
				break;

			case 1://Line
				g2d.draw(new Line2D.Double(x1, y1, x2, y2));
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
				break;

			case 3://Rectangle
				if (fill)
					g2d.fill(new Rectangle2D.Double(Math.min(x1, x2), Math.min(y1, y2),
							Math.abs(x2 - x1), Math.abs(y2 - y1)));
				else
					g2d.draw(new Rectangle2D.Double(Math.min(x1, x2), Math.min(y1, y2),
							Math.abs(x2 - x1), Math.abs(y2 - y1)));
				break;
			}
			try {
				out = new DataOutputStream(cs.getOutputStream());
				int red, green, blue;
				if (color == null)
					red = green = blue = 0;
				else {
					red = color.getRed();
					green = color.getGreen();
					blue = color.getBlue();
				}
				String StrPainter = x1 + "," + y1 + "," + x2 + "," + y2 + "," + tools + "," + size
						+ "," + fill + "," + red + "," + green + "," + blue;
				out.writeUTF(StrPainter);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				System.exit(1);
			}
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			mouseLocLabel
					.setText(String.format("Location:(%d,%d)", event.getX(), event.getY()));
			otherLabel.setText("In the Panel");
		}

		@Override
		public void mouseExited(MouseEvent event) {
			otherLabel.setText("Out of the Panel");
		}

		@Override
		public void mouseDragged(MouseEvent event) {
			Graphics g = getGraphics();
			g.setColor(color);
			if (tools == 0) //brush
			{
				x1 = event.getX();
				y1 = event.getY();
				g.fillOval(x1, y1, 10 * size, 10 * size);
				try {
					out = new DataOutputStream(cs.getOutputStream());
					int red, green, blue;
					if (color == null)
						red = green = blue = 0;
					else {
						red = color.getRed();
						green = color.getGreen();
						blue = color.getBlue();
					}
					String StrPainter = x1 + "," + y1 + "," + x2 + "," + y2 + "," + tools + ","
							+ size
							+ "," + fill + "," + red + "," + green + "," + blue;
					out.writeUTF(StrPainter);
				} catch (IOException ioe) {
					ioe.printStackTrace();
					System.exit(1);
				}

			}
			mouseLocLabel
					.setText(String.format("Location:[%d,%d]", event.getX(), event.getY()));
			otherLabel.setText("Dragging");
		}

		@Override
		public void mouseMoved(MouseEvent event) {
			mouseLocLabel
					.setText(String.format("Location:[%d,%d]", event.getX(), event.getY()));
		}
		//end inner class

	}//end class

	private class ConnectItemHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			showConnectDialog(event);
			buildClientSocket(ServerIP, ServerPort);
			listenToServer(cs);
		}

		private void showConnectDialog(ActionEvent event) {
			JTextField xField = new JTextField(9);
			JTextField yField = new JTextField(9);

			JPanel myPanel = new JPanel();
			myPanel.setLayout(new GridLayout(2, 2));
			myPanel.add(new JLabel("Server IP:"));
			myPanel.add(xField);
			myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			myPanel.add(new JLabel("Server Port:"));
			myPanel.add(yField);
			xField.setText("127.0.0.1");
			yField.setText("57968");
			int result = JOptionPane.showConfirmDialog(myPanel, myPanel,
					"Please Enter Server IP and Port", JOptionPane.OK_CANCEL_OPTION);

			if (result == JOptionPane.OK_OPTION) {
				ServerIP = xField.getText();
				ServerPort = Integer.parseInt(yField.getText());
				JOptionPane.showMessageDialog(null,"Connected Successfully ! ",
						"Successful", JOptionPane.PLAIN_MESSAGE);
			} else {

			}
		}

		private void buildClientSocket(String addr, int port) {
			try {
				cs = new Socket(InetAddress.getByName(addr), port);
				System.out.println("Build a Socket: " +
						cs.getInetAddress().getHostAddress() + "\n");

			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}

		private void listenToServer(Socket cs) {
			Thread thread = new Thread(new ClientPaintListenThread(cs));
			thread.start();
		}

	}

	private class ClearButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			otherLabel.setText("Clear!");
			repaint();
			try {
				out = new DataOutputStream(cs.getOutputStream());
				String StrClean = "clean";
				out.writeUTF(StrClean);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				System.exit(1);
			}
		}
	}//end inner class

	private class ColorButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			color = JColorChooser.showDialog(drawPanel, "Choose a Color", color);
			if (color == null)
				color = Color.BLACK;
		}
	}//end inner class

	private class ToolHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (BrushRB.isSelected()) {
				tools = 0;
				sizeStatusLabel.setText("Tools:Brush");
			}
			if (LineRB.isSelected()) {
				tools = 1;
				sizeStatusLabel.setText("Tools:Line");
			}
			if (OvalRB.isSelected()) {
				tools = 2;
				sizeStatusLabel.setText("Tools:Oval");
			}
			if (RectangleRB.isSelected()) {
				tools = 3;
				sizeStatusLabel.setText("Tools:Rectangle");
			}
		}
	}//end inner class

	private class SizeHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (brushSmallRB.isSelected()) {
				size = 1;
				sizeStatusLabel.setText("Size:Small");
			}
			if (brushMediumRB.isSelected()) {
				size = 2;
				sizeStatusLabel.setText("Size:Medium");
			}
			if (brushBigRB.isSelected()) {
				size = 3;
				sizeStatusLabel.setText("Size:Big");
			}
			fSize = (float) size * 3;
		}
	}//end inner class

	private class FillHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (fillChkB.isSelected()) {
				fillStatusLabel.setText("Fill:Yes");
				fill = true;
			} else {
				fillStatusLabel.setText("Fill:No");
				fill = false;
			}
		}
	}

}
