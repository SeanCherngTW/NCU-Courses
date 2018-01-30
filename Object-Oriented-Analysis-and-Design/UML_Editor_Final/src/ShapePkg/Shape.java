package ShapePkg;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Shape
{
	public int depth = 0;
	protected ImageIcon icon;
	protected Image image;

	public void setName(String name)
	{
		System.out.println("<DEBUG> Shape.setName() implementation error!");
	}
	
	public void setIsSelected(boolean isSelected)
	{
		System.out.println("<DEBUG> Shape.setIsSelected(boolean) implementation error!");
	}
	
	public boolean getIsSelected()
	{
		System.out.println("<DEBUG> Shape.getIsSelected() implementation error!");
		return false;
	}

	public int getX()
	{
		System.out.println("<DEBUG> Shape.getX() implementation error!");
		return -1;
	}
	
	public void setX(int x)
	{
		System.out.println("<DEBUG> Shape.setX() implementation error!");
	}

	public int getY()
	{
		System.out.println("<DEBUG> Shape.getY() implementation error!");
		return -1;
	}
	
	public void setY(int y)
	{
		System.out.println("<DEBUG> Shape.setY() implementation error!");
	}

	public int getXDrag()
	{
		System.out.println("<DEBUG> Shape.getXDrag() implementation error!");
		return -1;
	}
	
	public void setXDrag(int dx)
	{
		System.out.println("<DEBUG> Shape.setXDrag() implementation error!");
	}

	public int getYDrag()
	{
		System.out.println("<DEBUG> Shape.getYDrag() implementation error!");
		return -1;
	}
	
	public void setYDrag(int dy)
	{
		System.out.println("<DEBUG> Shape.setYDrag() implementation error!");
	}
	
	public void resetXDrag()
	{
		System.out.println("<DEBUG> Shape.resetXDrag() implementation error!");
	}

	public void resetYDrag()
	{
		System.out.println("<DEBUG> Shape.resetYDrag() implementation error!");
	}

	public int getTextX()
	{
		System.out.println("<DEBUG> Shape.getTextX() implementation error!");
		return -1;
	}

	public int getTextY()
	{
		System.out.println("<DEBUG> Shape.getTextY() implementation error!");
		return -1;
	}

	public int getWidth()
	{
		System.out.println("<DEBUG> Shape.getWidth() implementation error!");
		return -1;
	}

	public int getHeight()
	{
		System.out.println("<DEBUG> Shape.getHeight() implementation error!");
		return -1;
	}

	public String getName()
	{
		System.out.println("<DEBUG> Shape.getName() implementation error!");
		return "no name";
	}

	public boolean isInBasicObject(int x, int y)
	{
		System.out.println("<DEBUG> Shape.isInBasicObject(int, int) implementation error!");
		return false;
	}

	public boolean isInBasicObject(int x1, int y1, int x2, int y2)
	{
		System.out.println("<DEBUG> Shape.isInBasicObject(int, int, int, int) implementation error!");
		return false;
	}

	public void showPorts(boolean isSelected)
	{
		System.out.println("<DEBUG> Shape.showPorts(boolean) implementation error!");

	}
	
	public void initializePort()
	{
		System.out.println("<DEBUG> Shape.initializePort() implementation error!");
	}
	
	public void drawBasicObject(Graphics2D g2d)
	{
		System.out.println("<DEBUG> Shape.drawBasicObject(Graphics2D) implementation error!");
	}
	
	public Port getNearestPort(int x, int y)
	{
		System.out.println("<DEBUG> Shape.getNearestPort(int, int) implementation error!");
		return new Port(-1, -1);
	}
	
	public ArrayList<Shape> getMember()
	{
		System.out.println("<DEBUG> Shape.getMember() implementation error!");
		return new ArrayList<Shape>();
	}

	public Image getImage()
	{
		return image;
	}

	public void setImage(Image image)
	{
		this.image = image;
	}
}
