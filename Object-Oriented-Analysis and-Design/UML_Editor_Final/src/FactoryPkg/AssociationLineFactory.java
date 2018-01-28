package FactoryPkg;

import ShapePkg.AssociationLine;
import ShapePkg.LineObject;
import ShapePkg.Port;

public class AssociationLineFactory implements LineObjectFactory
{
	@Override
	public LineObject createLineObject(Port port1, Port port2)
	{
		return new AssociationLine(port1, port2);
	}
}
