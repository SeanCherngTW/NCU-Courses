package FactoryPkg;

import ShapePkg.BasicObject;
import ShapePkg.UseCase;

public class UseCaseFactory implements BasicObjectFactory
{
	@Override
	public BasicObject createBasicObject(int x, int y, int depth)
	{
		return new UseCase(x, y, depth);
	}
}
