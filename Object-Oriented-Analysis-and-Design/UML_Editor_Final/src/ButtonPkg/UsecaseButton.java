package ButtonPkg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import FactoryPkg.UseCaseFactory;
import MainPartPkg.Panel;

public class UsecaseButton extends Button implements ActionListener
{
	private static final long serialVersionUID = 1L;

	public UsecaseButton(String name)
	{
		super(name);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		canvas.lineObjectFactory = null;
		canvas.basicObjectFactory = new UseCaseFactory();
		Panel.resetButtonColor();
		setBackground(new Color(209, 209, 209));
	}
}