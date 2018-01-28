package MainPartPkg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import FactoryPkg.*;
import ShapePkg.*;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	private static Canvas instance = null;
	public LineObjectFactory lineObjectFactory;
	public BasicObjectFactory basicObjectFactory;
	public ArrayList<Shape> shapeList = new ArrayList<Shape>();
	private static ArrayList<LineObject> lineObjectList = new ArrayList<LineObject>();
	private static int depth = 0;

	private int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

	public Canvas()
	{
		this.setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public static Canvas getInstance()
	{
		if (instance == null)
			synchronized (Canvas.class)
			{
				if (instance == null)
					instance = new Canvas();
			}
		return instance;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.clearRect(0, 0, getWidth(), getHeight());
		Graphics2D g2d = (Graphics2D) g;
		for (Shape shape : shapeList)
			shape.drawBasicObject(g2d);

		for (LineObject lo : lineObjectList)
			lo.drawLine(g, lo.getPortStart(), lo.getPortEnd());
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		x2 = e.getX();
		y2 = e.getY();
		dragBasicObject(x1, y1, x2, y2);
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		selectShape(x1, y1);
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		x1 = e.getX();
		y1 = e.getY();
		checkCursorInObject(x1, y1);
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		x2 = e.getX();
		y2 = e.getY();
		for (Shape shape : shapeList)
		{
			shape.resetXDrag();
			shape.resetYDrag();
		}
		addBasicObject(x2, y2);
		addLineObject(x1, y1, x2, y2);

		if (x1 != x2 && y1 != y2)
			selectShapes(x1, y1, x2, y2);
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}
	
	private void selectShape(int x, int y)
	{
		if (!isSelectMode())
			return;

		boolean alreadySelect = false;

		for (int i = shapeList.size() - 1; i >= 0; i--)
		{
			Shape shape = shapeList.get(i);
			if (shape.isInBasicObject(x, y) && !alreadySelect)
			{
				shape.showPorts(true);
				alreadySelect = true;
			} else
				shape.showPorts(false);
		}

		repaint();
	}

	private void selectShapes(int x1, int y1, int x2, int y2)
	{
		if (!isSelectMode())
			return;

		if (x1 > x2)
		{
			int tmp = x1;
			x1 = x2;
			x2 = tmp;
		}

		if (y1 > y2)
		{
			int tmp = y1;
			y1 = y2;
			y2 = tmp;
		}

		for (int i = shapeList.size() - 1; i >= 0; i--)
		{
			Shape bo = shapeList.get(i);
			if (bo.isInBasicObject(x1, y1, x2, y2))
				bo.showPorts(true);
			else
				bo.showPorts(false);
		}
		repaint();
	}

	private void dragBasicObject(int x1, int y1, int x2, int y2)
	{
		if (!isSelectMode())
			return;

		int dx = x2 - x1;
		int dy = y2 - y1;

		for (Shape shape : shapeList)
			if (shape.getIsSelected())
			{
				shape.setXDrag(dx);
				shape.setYDrag(dy);
				shape.initializePort();
			}
		repaint();
	}

	private void addBasicObject(int x, int y)
	{
		if (basicObjectFactory == null)
			return;

		BasicObject newBasicObject = basicObjectFactory.createBasicObject(x, y, depth);
		depth++;
		shapeList.add(newBasicObject);
		repaint();
	}

	private void addLineObject(int x1, int y1, int x2, int y2)
	{
		if (lineObjectFactory == null)
			return;

		boolean isVaildLineStart = false;
		boolean isVaildLineEnd = false;
		Shape boStart = null;
		Shape boEnd = null;
		Port portStart = null;
		Port portEnd = null;

		/* Check if the connection line starts from a BasicObject. */
		for (Shape shape : shapeList)
			if (shape.isInBasicObject(x1, y1))
			{
				isVaildLineStart = true;
				portStart = shape.getNearestPort(x1, y1);
				boStart = shape;
				break;
			}

		/* Check if the connection line ends at a BasicObject. */
		for (Shape shape : shapeList)
			if (shape.isInBasicObject(x2, y2))
			{
				isVaildLineEnd = true;
				portEnd = shape.getNearestPort(x2, y2);
				boEnd = shape;
				break;
			}

		if (boStart == null || boEnd == null)
			return;

		if (boStart.equals(boEnd) || !(isVaildLineStart && isVaildLineEnd))
			return;

		LineObject newLineObject = lineObjectFactory.createLineObject(portStart, portEnd);
		lineObjectList.add(newLineObject);
		repaint();
	}

	private boolean isSelectMode()
	{
		if (basicObjectFactory == null && lineObjectFactory == null)
			return true;
		else
			return false;
	}

	private void checkCursorInObject(int x, int y)
	{
		for (Shape shape : shapeList)
			if (shape.isInBasicObject(x, y) && shape.getIsSelected())
				return;

		for (Shape shape : shapeList)
			shape.showPorts(false);
	}
}