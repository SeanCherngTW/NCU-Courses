import java.awt.Image;
import java.util.Random;
import java.util.Timer;

import javax.swing.ImageIcon;

public class Turtle implements Runnable {
	public static int deadTurtle = 0;
	private int posX, posY;
	private int speedX, speedY;
	private int size, direction, ranDirection;
	private static final int DOWN = 2;
	private static final int RIGHT = 1;
	private static final int LEFT = 0;
	private ImageIcon icon;
	private Image image;
	private final static Random ran = new Random();
	private final String[] imgRes = { "w1.png", "w2.png" };
	Timer timer = new Timer();

	public Turtle(int X, int Y) {
		// get the position of mouse click from user
		initTurtle(X, Y);
		checkDirection();
	}

	public void initTurtle(int X, int Y) {
		posX = X;
		posY = Y;
		speedX = ran.nextInt(5) + 1;
		speedY = ran.nextInt(5) + 5;
		size = 20 * (ran.nextInt(5) + 2);
		direction = DOWN;
		ranDirection = ran.nextInt(2);
	}

	public void checkDirection() {
		switch(direction){
		case DOWN:
			icon = new ImageIcon(getClass().getResource(imgRes[ranDirection]));
			break;
		
		case RIGHT:
			icon = new ImageIcon(getClass().getResource(imgRes[0]));
			break;
			
		case LEFT:
			icon = new ImageIcon(getClass().getResource(imgRes[1]));
			break;
		}
		image = icon.getImage();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
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
		case DOWN:
			posY += speedY;
			break;
			
		case RIGHT:
			posX += speedX;
			break;
			
		case LEFT:
			posX -= speedX;
			break;
		}
	}

	private void checkMargin() {
		switch (direction) {
		case DOWN:
			if (posY + size > Aquarium.botMarginY) 
				direction = ranDirection;
			break;
			
		case RIGHT:
			if (posX + size> Aquarium.rightMarginX)
				direction = LEFT;
			break;
			
		case LEFT:
			if (posX < Aquarium.leftMarginX)
				direction = RIGHT;
			break;
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
}
