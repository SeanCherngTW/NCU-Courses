package ShapePkg;

import java.util.ArrayList;

public class Port extends Shape
{
	private int x = 0;
	private int y = 0;
	private int xDrag;
	private int yDrag;
	private ArrayList<LineObject> LineStartList = new ArrayList<LineObject>();
	private ArrayList<LineObject> LineEndList = new ArrayList<LineObject>();

	public Port(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.xDrag = x;
		this.yDrag = y;
	}
	
	public void updatePos(int dx, int dy)
	{
		setX(this.getXDrag() + dx);
		setY(this.getYDrag() + dy);
	}
	
	public void setPos(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getXDrag()
	{
		return xDrag;
	}

	public void setXDrag(int xDrag)
	{
		this.xDrag = xDrag;
	}

	public int getYDrag()
	{
		return yDrag;
	}

	public void setYDrag(int yDrag)
	{
		this.yDrag = yDrag;
	}
	
	
	public void addStartLine(LineObject startLine) {
		LineStartList.add(startLine);
	}
	
	public void addEndLine(LineObject endLine) {
		LineEndList.add(endLine);
	}
}
