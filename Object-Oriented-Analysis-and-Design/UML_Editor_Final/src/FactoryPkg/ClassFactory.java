package FactoryPkg;

import ShapePkg.BasicObject;
import ShapePkg.Class;

public class ClassFactory implements BasicObjectFactory
{
	@Override
	public BasicObject createBasicObject(int x, int y, int depth)
	{
		return new Class(x, y, depth);
	}
}
