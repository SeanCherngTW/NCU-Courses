package FactoryPkg;

import ShapePkg.LineObject;
import ShapePkg.Port;

public interface LineObjectFactory
{
	public LineObject createLineObject(Port port1, Port port2);
}
