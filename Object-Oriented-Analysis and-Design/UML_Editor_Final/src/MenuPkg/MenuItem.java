package MenuPkg;

import javax.swing.JMenuItem;

import MainPartPkg.Canvas;
import MainPartPkg.Frame;

public class MenuItem extends JMenuItem
{
	private static final long serialVersionUID = 1L;
	
	protected Canvas canvas;
	protected Frame frame;

	public MenuItem(String name)
	{
		super(name);
		canvas = Canvas.getInstance();
		frame = Frame.getInstance();
	}
}
