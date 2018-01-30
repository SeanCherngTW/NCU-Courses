package ButtonPkg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import FactoryPkg.GeneralizationLineFactory;
import MainPartPkg.Panel;

public class GeneralizationLineButton extends Button implements ActionListener
{
	private static final long serialVersionUID = 1L;

	public GeneralizationLineButton(String name)
	{
		super(name);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		canvas.lineObjectFactory = new GeneralizationLineFactory();
		canvas.basicObjectFactory = null;
		Panel.resetButtonColor();
		setBackground(new Color(209, 209, 209));
	}
}