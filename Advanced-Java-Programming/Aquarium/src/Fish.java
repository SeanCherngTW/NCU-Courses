import java.awt.Image;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Fish implements Runnable {
	public static int deadFish = 0;
	private int posX, posY;
	private int speedX, speedY;
	private int style, size, direction;
	private static final int RIGHT_UP = 0;
	private static final int LEFT_UP = 1;
	private static final int LEFT_DOWN = 2;
	private static final int RIGHT_DOWN = 3;
	private static final int DEAD = 4;
	private ImageIcon icon;
	private Image image;
	private final static Random ran = new Random();
	private final String[] imgRes = { "1.png", "2.png", "3.png",
			"4.png", "5.png", "6.png", "fishBone.png" };
	Timer timer = new Timer();

	public Fish(int X, int Y) {
		// get the position of mouse click from user
		initFish(X, Y);
		checkDirection();
	}

	public void initFish(int X, int Y) {
		posX = X;
		posY = Y;
		speedX = ran.nextInt(5) + 1;
		speedY = ran.nextInt(5) + 1;
		style = ran.nextInt(3);
		//size = 20 * (ran.nextInt(5) + 2);
		size = 120;
		direction = ran.nextInt(4);
	}

	public void checkDirection() {
		switch (style) {
		case 0:
			if (direction == RIGHT_UP || direction == RIGHT_DOWN)
				icon = new ImageIcon(getClass().getResource(imgRes[0]));
			if (direction == LEFT_UP || direction == LEFT_DOWN)
				icon = new ImageIcon(getClass().getResource(imgRes[1]));
			if (direction == DEAD)
				icon = new ImageIcon(getClass().getResource(imgRes[6]));
			break;

		case 1:
			if (direction == RIGHT_UP || direction == RIGHT_DOWN)
				icon = new ImageIcon(getClass().getResource(imgRes[2]));
			if (direction == LEFT_UP || direction == LEFT_DOWN)
				icon = new ImageIcon(getClass().getResource(imgRes[3]));
			if (direction == DEAD)
				icon = new ImageIcon(getClass().getResource(imgRes[6]));
			break;

		case 2:
			if (direction == RIGHT_UP || direction == RIGHT_DOWN)
				icon = new ImageIcon(getClass().getResource(imgRes[4]));
			if (direction == LEFT_UP || direction == LEFT_DOWN)
				icon = new ImageIcon(getClass().getResource(imgRes[5]));
			if (direction == DEAD)
				icon = new ImageIcon(getClass().getResource(imgRes[6]));
			break;

		}
		image = icon.getImage();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//int interval = ran.nextInt(5000)+5000;
		timer.schedule(new ChangeStatus(), 5000, 5000);
		while (true) {
			try {
				move();
				checkMargin();
				checkDirection();
				Thread.sleep(15);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void move() {
		switch (direction) {
		case RIGHT_UP:
			posX += speedX;
			posY -= speedY;
			break;
		case LEFT_UP:
			posX -= speedX;
			posY -= speedY;
			break;
		case LEFT_DOWN:
			posX -= speedX;
			posY += speedY;
			break;
		case RIGHT_DOWN:
			posX += speedX;
			posY += speedY;
			break;
		case DEAD:
			posY += 3 * speedY;
			timer.cancel();
			timer.purge();
			break;
		}
	}

	private void checkMargin() {
		switch (direction) {
		case RIGHT_UP:
			if (posY < Aquarium.topMarginY)
				direction = RIGHT_DOWN;

			if (posX + size > Aquarium.rightMarginX)
				direction = LEFT_UP;
			break;

		case LEFT_UP:
			if (posY < Aquarium.topMarginY)
				direction = LEFT_DOWN;

			if (posX < Aquarium.leftMarginX)
				direction = RIGHT_UP;
			break;

		case LEFT_DOWN:
			if (posY + size > Aquarium.botMarginY)
				direction = LEFT_UP;

			if (posX < Aquarium.leftMarginX)
				direction = RIGHT_DOWN;
			break;

		case RIGHT_DOWN:
			if (posY + size > Aquarium.botMarginY)
				direction = RIGHT_UP;

			if (posX + size > Aquarium.rightMarginX)
				direction = LEFT_DOWN;
			break;

		case DEAD:
			if (posY + size > Aquarium.botMarginY) {
				speedX = 0;
				speedY = 0;
			}
			break;
		}
	}

	class ChangeStatus extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			size -= 20;
			if (size <= 40) {
				direction = DEAD;
				size += 20;
				deadFish++;
			}
		}
	}

	public int getLeftX() {
		return posX;
	}

	public int getRightX() {
		return posX + size;
	}

	public int getTopY() {
		return posY;
	}

	public int getBotY() {
		return posY + size;
	}

	public Image getImage() {
		return image;
	}

	public int getSize() {
		return size;
	}

	public void addSize() {
		if (direction != DEAD) {
			size += 20;
			if (size > 120){
				direction = DEAD;
				deadFish++;
			}
		}
	}

	public void setDirection(int dir) {
		direction = dir;
	}
}
