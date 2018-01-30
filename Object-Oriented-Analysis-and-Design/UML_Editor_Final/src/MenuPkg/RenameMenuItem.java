package MenuPkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ShapePkg.Shape;

public class RenameMenuItem extends MenuItem implements ActionListener
{
	private static final long serialVersionUID = 1L;

	public RenameMenuItem(String name)
	{
		super(name);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		showRenameDialog(e);
	}

	private void showRenameDialog(ActionEvent e)
	{
		JTextField renameField = new JTextField(20);
		JPanel renamePanel = new JPanel();
		renamePanel.add(renameField);

		int result = JOptionPane.showConfirmDialog(renamePanel, renamePanel, "Enter a new name",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION)
		{
			for (Shape shape : canvas.shapeList)
				if (shape.getIsSelected())
					shape.setName(renameField.getText());

			canvas.repaint();
		}
	}
}
