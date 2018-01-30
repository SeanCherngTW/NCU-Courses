package ButtonPkg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import FactoryPkg.ClassFactory;
import MainPartPkg.Panel;

public class ClassButton extends Button implements ActionListener
{
	private static final long serialVersionUID = 1L;

	public ClassButton(String name)
	{
		super(name);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		canvas.lineObjectFactory = null;
		canvas.basicObjectFactory = new ClassFactory();
		Panel.resetButtonColor();
		setBackground(new Color(209, 209, 209));
	}
}
