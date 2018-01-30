package ButtonPkg;

import java.awt.Color;

import javax.swing.JButton;

import MainPartPkg.Canvas;
import MainPartPkg.Panel;

public abstract class Button extends JButton
{
	private static final long serialVersionUID = 1L;

	protected Canvas canvas;
	protected Panel panel;

	public Button(String name)
	{
		super(name);
		canvas = Canvas.getInstance();
//		panel = Panel.getInstance();
		setBackground(new Color(255, 255, 255));
	}
}
