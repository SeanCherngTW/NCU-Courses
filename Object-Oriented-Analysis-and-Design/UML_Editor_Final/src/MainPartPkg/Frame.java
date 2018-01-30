package MainPartPkg;

import java.awt.*;
import javax.swing.*;

import MenuPkg.MenuBar;

public class Frame extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static Frame instance = null;
	private Panel toolPanel;
	private Canvas canvas;
	private MenuBar menuBar;

	public static Frame getInstance()
	{
		if (instance == null)
			synchronized (Frame.class)
			{
				if (instance == null)
					instance = new Frame();
			}
		return instance;
	}

	public Frame()
	{
		super("UML Editor");

		instance = this;
		canvas = Canvas.getInstance();
		toolPanel = Panel.getInstance();
		setLayout(new BorderLayout());

		menuBar = MenuBar.getInstance();
		setJMenuBar(menuBar);

		canvas.setBackground(Color.WHITE);

		add(toolPanel, BorderLayout.WEST);
		add(canvas, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1280, 720);
		setVisible(true);
	}
} // end Frame
