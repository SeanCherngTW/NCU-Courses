package ButtonPkg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import FactoryPkg.AssociationLineFactory;
import MainPartPkg.Panel;

public class AssociationLineButton extends Button implements ActionListener
{
	private static final long serialVersionUID = 1L;

	public AssociationLineButton(String name)
	{
		super(name);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		canvas.lineObjectFactory = new AssociationLineFactory();
		canvas.basicObjectFactory = null;
		Panel.resetButtonColor();
		setBackground(new Color(209, 209, 209));
	}
}
