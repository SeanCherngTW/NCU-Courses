package ShapePkg;

import java.awt.Graphics;

public abstract class LineObject extends Shape
{
	private Port portStart;
	private Port portEnd;
	
	public void createLineObject(Port portStart, Port portEnd)
	{
		this.portStart = portStart;
		this.portEnd = portEnd;
	}
	
	public abstract void drawLine(Graphics g, Port portStart, Port portEnd);
	
	public Port getPortStart() {
		return portStart;
	}
	
	public void setPortStart(Port portStart) {
		this.portStart = portStart;
	}
	
	public Port getPortEnd() {
		return portEnd;
	}
	
	public void setPortEnd(Port portEnd) {
		this.portEnd = portEnd;
	}
}

