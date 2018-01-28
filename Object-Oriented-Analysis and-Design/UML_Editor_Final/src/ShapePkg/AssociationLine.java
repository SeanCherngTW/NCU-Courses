package ShapePkg;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class AssociationLine extends LineObject
{
	public AssociationLine(Port port1, Port port2)
	{
		super.createLineObject(port1, port2);
	}
	
	@Override
	public void drawLine(Graphics g, Port portStart, Port portEnd)
	{
		Graphics2D g2d = (Graphics2D) g.create();

		double dx = portEnd.getX() - portStart.getX(), dy = portEnd.getY() - portStart.getY();
		double angle = Math.atan2(dy, dx);
		int len = (int) Math.sqrt(dx * dx + dy * dy);
		AffineTransform at = AffineTransform.getTranslateInstance(portStart.getX(), portStart.getY());
		at.concatenate(AffineTransform.getRotateInstance(angle));
		g2d.transform(at);
		g2d.drawLine(0, 0, len, 0);
	}
}
