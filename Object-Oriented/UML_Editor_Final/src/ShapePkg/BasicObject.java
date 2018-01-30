package ShapePkg;

import java.awt.Graphics2D;
import java.util.ArrayList;

public abstract class BasicObject extends Shape
{
	private int x;
	private int y;
	private int xDrag;
	private int yDrag;
	private int height;
	private int width;
	private String Name = "No name";
	private boolean isSelected = false;
	public ArrayList<Port> portList = new ArrayList<Port>(4);

	public abstract int getTextX();

	public abstract int getTextY();

	protected abstract void initialize();

	public abstract void initializePort();

	public abstract void showPorts(boolean isSelected);

	@Override
	public boolean getIsSelected()
	{
		return isSelected;
	}

	@Override
	public void setIsSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}

	public void createBasicObject(int x, int y, int depth)
	{
		this.x = x;
		this.y = y;
		this.xDrag = x;
		this.yDrag = y;
		super.depth = depth;
	}

	@Override
	public boolean isInBasicObject(int x, int y)
	{
		if (x > this.x && x < this.x + width && y > this.y && y < this.y + height)
			return true;
		else
			return false;
	}

	@Override
	public boolean isInBasicObject(int x1, int y1, int x2, int y2)
	{
		if (x1 < this.getX() && y1 < this.getY() && x2 > this.getX() + this.getWidth()
				&& y2 > this.getY() + this.getHeight())
			return true;
		else
			return false;
	}

	public Port getNearestPort(int x, int y)
	{
		int minDistance = 10000;
		Port nearestPort = portList.get(0);

		for (Port port : portList)
		{
			int curDistance = (Math.abs(x - port.getX()) ^ 2) + (Math.abs(y - port.getY()) ^ 2);
			if (minDistance > curDistance)
			{
				minDistance = curDistance;
				nearestPort = port;
			}
		}
		return nearestPort;
	}

	@Override
	public void drawBasicObject(Graphics2D g2d)
	{
		g2d.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(), null);
		g2d.drawString(getName(), getTextX(), getTextY());
	}

	@Override
	public int getX()
	{
		return x;
	}

	@Override
	public void setX(int x)
	{
		this.x = x;
	}

	@Override
	public int getY()
	{
		return y;
	}

	@Override
	public void setY(int y)
	{
		this.y = y;
	}

	@Override
	public void setXDrag(int dx)
	{
		x = getXDrag() + dx;
	}

	@Override
	public void setYDrag(int dy)
	{
		y = getYDrag() + dy;
	}

	@Override
	public int getXDrag()
	{
		return xDrag;
	}

	@Override
	public void resetXDrag()
	{
		xDrag = x;
	}

	@Override
	public int getYDrag()
	{
		return yDrag;
	}

	@Override
	public void resetYDrag()
	{
		yDrag = y;
	}

	@Override
	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	@Override
	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	@Override
	public String getName()
	{
		return Name;
	}

	@Override
	public void setName(String Name)
	{
		this.Name = Name;
	}
	
	public ArrayList<Shape> getMember()
	{
		ArrayList<Shape> shapeList = new ArrayList<Shape>();
		shapeList.add(this);
		return shapeList;
	}
}
