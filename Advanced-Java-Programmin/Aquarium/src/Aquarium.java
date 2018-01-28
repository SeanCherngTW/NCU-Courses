import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;

// 2.13.2016 from SeanCherng's MAC
public class Aquarium extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel toolStatusLabel, fishStatusLabel;
	private JPanel toolPanel, statusPanel, topPanel;
	private static JPanel aquariumPanel;
	private JButton addFishBtn, addTurtleBtn, removeBtn, feedBtn;
	private static int function = 0;
	private static final int ADD_FISH = 1;
	private static final int ADD_TURTLE = 2;
	private static final int REMOVE = 3;
	private static final int FEED = 4;
	public static int leftMarginX, rightMarginX, topMarginY, botMarginY;
	ExecutorService executor = Executors.newCachedThreadPool();
	ExecutorService executor2 = Executors.newFixedThreadPool(1);
	static ArrayList<Fish> fishList = new ArrayList<Fish>();
	static ArrayList<Turtle> turtleList = new ArrayList<Turtle>();
	Timer timer = new Timer();

	public static void main(String[] args) {
		Aquarium aquarium = new Aquarium();
		aquarium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aquarium.setResizable(false);
		aquarium.setSize(1024, 600);
		aquarium.setVisible(true);

		leftMarginX = 0;
		rightMarginX = aquariumPanel.getWidth();
		topMarginY = 0;
		botMarginY = aquariumPanel.getHeight();
	}

	public Aquarium() {
		super("Aquarium");

		/* Main Frame */
		toolPanel = new JPanel();
		statusPanel = new JPanel();
		topPanel = new JPanel();
		aquariumPanel = new AquariumPanel();
		setLayout(new BorderLayout());
		/* Main Frame */

		/* Tool Panel */
		addFishBtn = new JButton("Add a new Fish");
		addTurtleBtn = new JButton("Add a new Turtle");
		removeBtn = new JButton("Remove");
		feedBtn = new JButton("Feed");

		addFishBtn.addActionListener(new AddFishBtnHandler());
		addTurtleBtn.addActionListener(new AddTurtleBtnHandler());
		removeBtn.addActionListener(new RemoveBtnHandler());
		feedBtn.addActionListener(new FeedBtnHandler());

		toolPanel.add(addFishBtn);
		toolPanel.add(removeBtn);
		toolPanel.add(addTurtleBtn);
		toolPanel.add(feedBtn);
		toolPanel.setLayout(new GridLayout(2, 2, 0, 0));
		/* Tool Panel */

		/* Status Panel */
		toolStatusLabel = new JLabel("Please select a function");
		fishStatusLabel = new JLabel(
				String.format("Fish: %-3d Dead Fish: %-3d Turtle: %-3d Dead Turtle: %-3d",
						fishList.size() - Fish.deadFish, Fish.deadFish,
						turtleList.size() - Turtle.deadTurtle, Turtle.deadTurtle));

		toolStatusLabel.setFont((new Font("Consolas", Font.BOLD, 18)));
		fishStatusLabel.setFont((new Font("Consolas", Font.BOLD, 18)));
		toolStatusLabel.setForeground(new Color(135, 206, 250));
		fishStatusLabel.setForeground(new Color(135, 206, 250));

		statusPanel.add(toolStatusLabel);
		statusPanel.add(fishStatusLabel);
		statusPanel.setLayout(new GridLayout(1, 2, 0, 0));
		statusPanel.setBackground(new Color(39, 39, 39));
		/* Status Panel */

		/* Top Panel */
		topPanel.add(toolPanel);
		topPanel.add(statusPanel);
		topPanel.setLayout(new GridLayout(2, 1, 0, 0));
		/* Top Panel */

		aquariumPanel.setBackground(new Color(0, 75, 151));

		add(topPanel, BorderLayout.NORTH);
		add(aquariumPanel, BorderLayout.CENTER);

		executor2.execute((Runnable) new AquariumPanel());
		timer.schedule(new UpdateText(), 10, 10);
	}

	private class AddFishBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			function = ADD_FISH;
			toolStatusLabel.setText("Click to add a fish");
		}
	}

	private class AddTurtleBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			function = ADD_TURTLE;
			toolStatusLabel.setText("Click to add a turtle");
		}
	}

	private class RemoveBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			function = REMOVE;
			toolStatusLabel.setText("Click to remove");
		}
	}

	private class FeedBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			function = FEED;
			toolStatusLabel.setText("Click to feed");
		}
	}

	public void updateText() {
		fishStatusLabel.setText(
				String.format("Fish: %-3d Dead Fish: %-3d Turtle: %-3d Dead Turtle: %-3d",
						fishList.size() - Fish.deadFish, Fish.deadFish,
						turtleList.size() - Turtle.deadTurtle, Turtle.deadTurtle));
	}

	class UpdateText extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			fishStatusLabel.setText(
					String.format("Fish: %-3d Dead Fish: %-3d Turtle: %-3d Dead Turtle: %-3d",
							fishList.size() - Fish.deadFish, Fish.deadFish,
							turtleList.size() - Turtle.deadTurtle, Turtle.deadTurtle));
		}
	}

	class AquariumPanel extends JPanel implements MouseListener, MouseMotionListener, Runnable {
		private static final long serialVersionUID = 1L;
		int clickX, clickY;

		public AquariumPanel() {
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				aquariumPanel.repaint();
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					JOptionPane.showMessageDialog(this, "Thread sleeping error.");
				}
			}
		}

		public void paintComponent(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			for (Fish fish : fishList)
				g2d.drawImage(fish.getImage(), fish.getLeftX(), fish.getTopY(), fish.getSize(),
						fish.getSize(), null);

			for (Turtle turtle : turtleList)
				g2d.drawImage(turtle.getImage(), turtle.getLeftX(), turtle.getTopY(),
						turtle.getSize(),
						turtle.getSize(), null);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			clickX = e.getX() - 40;
			clickY = e.getY() - 40;

			switch (function) {
			case ADD_FISH:
				Fish fish = new Fish(clickX, clickY);
				fishList.add(fish);
				executor.execute(fish); // let the fish moves
				break;

			case ADD_TURTLE:
				Turtle turtle = new Turtle(clickX, clickY);
				turtleList.add(turtle);
				executor.execute(turtle); // let the fish moves
				break;

			case REMOVE:
				boolean isTurtleRemoved = false;
				// You can only remove one creature in one click

				for (Turtle removeTurtle : turtleList) {
					if (e.getX() > removeTurtle.getLeftX() &&
							e.getX() < removeTurtle.getRightX() &&
							e.getY() > removeTurtle.getTopY() &&
							e.getY() < removeTurtle.getBotY()) {
						turtleList.remove(removeTurtle);
						isTurtleRemoved = true;
						break;
					}
				}

				if (!isTurtleRemoved)
					for (Fish removeFish : fishList) {
						if (e.getX() > removeFish.getLeftX() &&
								e.getX() < removeFish.getRightX() &&
								e.getY() > removeFish.getTopY() &&
								e.getY() < removeFish.getBotY()) {
							removeFish.setDirection(4);
							Fish.deadFish++;
							//fishList.remove(removeFish);
							break;
						}
					}
				break;

			case FEED:
				boolean isTurtleFed = false;
				// You can only remove one creature in one click

				for (Turtle removeTurtle : turtleList) {
					if (e.getX() > removeTurtle.getLeftX() &&
							e.getX() < removeTurtle.getRightX() &&
							e.getY() > removeTurtle.getTopY() &&
							e.getY() < removeTurtle.getBotY()) {
						//removeTurtle.addSize();
						isTurtleRemoved = true;
						break;
					}
				}

				if (!isTurtleFed)
					for (Fish removeFish : fishList) {
						if (e.getX() > removeFish.getLeftX() &&
								e.getX() < removeFish.getRightX() &&
								e.getY() > removeFish.getTopY() &&
								e.getY() < removeFish.getBotY()) {
							removeFish.addSize();
							//removeFish.setDirection(4);
							//fishList.remove(removeFish);
							break;
						}
					}
				break;
			}
			fishStatusLabel.setText(
					String.format("Fish: %-3d Dead Fish: %-3d Turtle: %-3d Dead Turtle: %-3d",
							fishList.size() - Fish.deadFish, Fish.deadFish,
							turtleList.size() - Turtle.deadTurtle, Turtle.deadTurtle));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	}
}
