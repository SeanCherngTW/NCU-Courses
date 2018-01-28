package FactoryPkg;

import ShapePkg.BasicObject;

public interface BasicObjectFactory
{
	public BasicObject createBasicObject(int x, int y, int depth);
}
