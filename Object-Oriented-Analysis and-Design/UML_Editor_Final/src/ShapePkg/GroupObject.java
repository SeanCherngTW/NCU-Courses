package ShapePkg;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GroupObject extends Shape
{
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();

	public void add(Shape shape)
	{
		shapeList.add(shape);
	}

	public ArrayList<Shape> getMember()
	{
		return shapeList;
	}

	@Override
	public boolean getIsSelected()
	{
		for (Shape shape : shapeList)
			if (shape.getIsSelected())
				return true;

		return false;
	}

	@Override
	public void setXDrag(int dx)
	{
		for (Shape shape : shapeList)
			shape.setXDrag(dx);
	}

	@Override
	public void setYDrag(int dy)
	{
		for (Shape shape : shapeList)
			shape.setYDrag(dy);
	}

	@Override
	public void resetXDrag()
	{
		for (Shape shape : shapeList)
			shape.resetXDrag();
	}

	@Override
	public void resetYDrag()
	{
		for (Shape shape : shapeList)
			shape.resetYDrag();
	}

	@Override
	public void initializePort()
	{
		for (Shape shape : shapeList)
			shape.initializePort();
	}

	@Override
	public boolean isInBasicObject(int x, int y)
	{
		for (Shape shape : shapeList)
			if (shape.isInBasicObject(x, y))
				return true;
		return false;
	}

	@Override
	public boolean isInBasicObject(int x1, int y1, int x2, int y2)
	{
		for (Shape shape : shapeList)
			if (shape.isInBasicObject(x1, y1, x2, y2))
				return true;
		return false;
	}

	@Override
	public void showPorts(boolean isSelected)
	{
		for (Shape shape : shapeList)
			shape.showPorts(isSelected);
	}

	@Override
	public void drawBasicObject(Graphics2D g2d)
	{
		for (Shape shape : shapeList)
			shape.drawBasicObject(g2d);
	}

	@Override
	public Port getNearestPort(int x, int y)
	{
		ArrayList<Port> portList = new ArrayList<Port>();
		for (Shape shape : shapeList)
			portList.add(shape.getNearestPort(x, y));

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
}
