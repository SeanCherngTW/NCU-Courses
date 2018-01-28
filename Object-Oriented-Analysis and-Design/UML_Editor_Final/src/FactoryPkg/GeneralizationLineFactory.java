package FactoryPkg;

import ShapePkg.GeneralizationLine;
import ShapePkg.LineObject;
import ShapePkg.Port;

public class GeneralizationLineFactory implements LineObjectFactory
{
	@Override
	public LineObject createLineObject(Port port1, Port port2)
	{
		return new GeneralizationLine(port1, port2);
	}
}
