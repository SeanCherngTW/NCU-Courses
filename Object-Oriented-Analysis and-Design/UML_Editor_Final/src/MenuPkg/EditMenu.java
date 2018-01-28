package MenuPkg;

public class EditMenu extends Menu
{
	private static final long serialVersionUID = 1L;

	public EditMenu(String name)
	{
		super(name);
		add(new RenameMenuItem("Rename"));
		add(new GroupMenuItem("Group"));
		add(new UnGroupMenuItem("Ungroup"));
	}
}
