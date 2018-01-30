package MenuPkg;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar
{
	private static final long serialVersionUID = 1L;
	
	private static MenuBar instance = null;
	
	public static MenuBar getInstance()
	{
		if (instance == null)
			synchronized (MenuBar.class)
			{
				if (instance == null)
					instance = new MenuBar();
			}
		return instance;
	}

	public MenuBar()
	{
		add(new FileMenu("File"));
		add(new EditMenu("Edit"));
	}
}
