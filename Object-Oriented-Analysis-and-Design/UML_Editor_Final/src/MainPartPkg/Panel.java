package MainPartPkg;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import ButtonPkg.*;

public class Panel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private static Panel instance = null;

	private static ArrayList<Button> buttonList = new ArrayList<Button>();

	public Panel()
	{
		initializeButton();
		setLayout(new GridLayout(6, 1, 0, 0));
	}

	public static Panel getInstance()
	{
		if (instance == null)
			synchronized (Panel.class)
			{
				if (instance == null)
					instance = new Panel();
			}
		return instance;
	}

	public static void resetButtonColor()
	{
		for(Button button : buttonList)
			button.setBackground(new Color(255, 255, 255));
	} 
	
	private void initializeButton()
	{
		Button selectbutton = new SelectButton("Select");
		Button associationLineButton = new AssociationLineButton("Association Line");
		Button generalizationLineButton = new GeneralizationLineButton("Generalization Line");
		Button compositionLineButton = new CompositionLineButton("Composition Line");
		Button classButton = new ClassButton("Class");
		Button usecaseButton = new UsecaseButton("Usecase");

		add(selectbutton);
		add(associationLineButton);
		add(generalizationLineButton);
		add(compositionLineButton);
		add(classButton);
		add(usecaseButton);
		
		buttonList.add(selectbutton);
		buttonList.add(associationLineButton);
		buttonList.add(generalizationLineButton);
		buttonList.add(compositionLineButton);
		buttonList.add(classButton);
		buttonList.add(usecaseButton);
	}
}
