package MenuPkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ShapePkg.Shape;

public class UnGroupMenuItem extends MenuItem implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	public UnGroupMenuItem(String name)
	{
		super(name);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		unGroup();
	}
	
	private void unGroup()
	{
		ArrayList<Shape> toAddList = new ArrayList<Shape>();
		ArrayList<Shape> toDeleteList = new ArrayList<Shape>();
		
		for (Shape shape : canvas.shapeList)
			if (shape.getIsSelected())
			{
				toDeleteList.add(shape);
				toAddList.addAll(shape.getMember());
			}
		
		canvas.shapeList.removeAll(toDeleteList);
		canvas.shapeList.addAll(toAddList);
	}
}
