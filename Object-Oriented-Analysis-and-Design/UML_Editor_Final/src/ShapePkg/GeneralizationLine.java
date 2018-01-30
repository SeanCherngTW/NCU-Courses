package ShapePkg;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class GeneralizationLine extends LineObject
{
	public GeneralizationLine(Port port1, Port port2)
	{
		super.createLineObject(port1, port2);
	}

	@Override
	public void drawLine(Graphics g, Port portStart, Port portEnd)
	{
		final int MAX = 10;

		Graphics2D g2d = (Graphics2D) g.create();

		double dx = portEnd.getX() - portStart.getX(), dy = portEnd.getY() - portStart.getY();
		double angle = Math.atan2(dy, dx);
		int len = (int) Math.sqrt(dx * dx + dy * dy);
		AffineTransform at = AffineTransform.getTranslateInstance(portStart.getX(), portStart.getY());
		at.concatenate(AffineTransform.getRotateInstance(angle));
		g2d.transform(at);

		// Draw horizontal arrow starting in (0, 0)
		g2d.drawLine(0, 0, len - MAX, 0);
		g2d.drawPolygon(new int[] { len, len - MAX, len - MAX, len }, new int[] { 0, -MAX, MAX, 0 }, 4);
	}
}
