package MenuPkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ShapePkg.GroupObject;
import ShapePkg.Shape;

public class GroupMenuItem extends MenuItem implements ActionListener
{
	private static final long serialVersionUID = 1L;

	public GroupMenuItem(String name)
	{
		super(name);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		createGroup();
	}
	
	private void createGroup()
	{
		GroupObject newGroupObject = new GroupObject();

		for (Shape shape : canvas.shapeList)
			if (shape.getIsSelected())
				newGroupObject.add(shape);

		canvas.shapeList.removeAll(newGroupObject.getMember());
		canvas.shapeList.add(newGroupObject);
	}
}
