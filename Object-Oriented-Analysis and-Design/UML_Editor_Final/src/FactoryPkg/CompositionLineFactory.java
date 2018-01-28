package FactoryPkg;

import ShapePkg.CompositionLine;
import ShapePkg.LineObject;
import ShapePkg.Port;

public class CompositionLineFactory implements LineObjectFactory
{
	@Override
	public LineObject createLineObject(Port port1, Port port2)
	{
		return new CompositionLine(port1, port2);
	}
}
