package ButtonPkg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MainPartPkg.Panel;

public class SelectButton extends Button implements ActionListener
{
	private static final long serialVersionUID = 1L;

	public SelectButton(String name)
	{
		super(name);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		canvas.lineObjectFactory = null;
		canvas.basicObjectFactory = null;
		Panel.resetButtonColor();
		setBackground(new Color(209, 209, 209));
	}
}
