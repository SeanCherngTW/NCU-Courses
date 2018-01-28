package com.deitel.ch17;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedHashSet;
import javax.swing.border.Border;

public class FileAndLinkedList extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel topPanel, mainPanel, botPanel;
	private JLabel fileNameLabel, insertLabel, deleteLabel, pathLabel;
	private JButton insertBtn, deleteBtn, loadBtn, saveBtn, clearBtn;
	private JTextField insertTxt, deleteTxt;
	private JTextArea mainTxt;
	private static LinkedHashSet<AccountRecordSerializable> accountSet = new LinkedHashSet<AccountRecordSerializable>();
	private static File selectedFile;
	private ObjectOutputStream output = null;
	private ObjectInputStream is = null;

	public FileAndLinkedList() {
		super("File & LinkedList Practice");
		/* panel base */
		topPanel = new JPanel();
		mainPanel = new JPanel();
		botPanel = new JPanel();
		/* panel base */

		/* GUI for topPanel */
		fileNameLabel = new JLabel("File name: ");
		insertLabel = new JLabel("Insert data: ");
		deleteLabel = new JLabel("Delete data: ");
		pathLabel = new JLabel("Path: ");
		insertTxt = new JTextField();
		deleteTxt = new JTextField();
		insertBtn = new JButton("Insert");
		deleteBtn = new JButton("Delete");
		loadBtn = new JButton("Load");

		topPanel.add(fileNameLabel);
		topPanel.add(pathLabel);
		topPanel.add(loadBtn);
		topPanel.add(insertLabel);
		topPanel.add(insertTxt);
		topPanel.add(insertBtn);
		topPanel.add(deleteLabel);
		topPanel.add(deleteTxt);
		topPanel.add(deleteBtn);
		topPanel.setLayout(new GridLayout(3, 3, 0, 0));

		loadBtn.addActionListener(new LoadBtnHandler());
		insertBtn.addActionListener(new InsertBtnHandler());
		deleteBtn.addActionListener(new DeleteBtnHandler());

		insertBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		/* GUI for topPanel */

		/* GUI for mainPanel */
		mainTxt = new JTextArea("Please input a file name in the text field.");
		mainPanel.add(mainTxt);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		mainTxt.setBorder(BorderFactory.createCompoundBorder(border,
				BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		mainPanel.setLayout(new GridLayout(1, 1, 0, 0));
		/* GUI for mainPanel */

		/* GUI for botPanel */
		saveBtn = new JButton("Save");
		clearBtn = new JButton("Clear");
		botPanel.add(saveBtn);
		botPanel.add(clearBtn);
		botPanel.setLayout(new GridLayout(1, 2, 0, 0));

		saveBtn.addActionListener(new SaveBtnHandler());
		clearBtn.addActionListener(new ClearBtnHandler());

		clearBtn.setEnabled(false);
		saveBtn.setEnabled(false);
		/* GUI for botPanel */

		add(topPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		add(botPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		FileAndLinkedList fl = new FileAndLinkedList();
		fl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fl.setResizable(false);
		fl.setSize(1024, 768);
		fl.setVisible(true);
	}

	private class LoadBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(FileAndLinkedList.this);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				selectedFile = fileChooser.getSelectedFile();
				fileNameLabel.setText("File name: " + selectedFile.getName());
				pathLabel.setText("Path: " + selectedFile.getPath());
				loadFile(selectedFile);
				activateButton();
			}
		}
	}//end LoadBtnHandler

	private void loadFile(File file) {
		try {
			mainTxt.setText("");
			is = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				AccountRecordSerializable account = new AccountRecordSerializable();
				account = (AccountRecordSerializable) is.readObject();
				mainTxt.append(String.format("%-30s\t%-15.1f\t%-15.1f\n",
						account.getName(), account.getScore1(), account.getScore2()));
				accountSet.add(account);
			}
		} catch (EOFException endOfFileException) {
			return;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//end loadFile()

	private void activateButton() {
		insertBtn.setEnabled(true);
		clearBtn.setEnabled(true);
		saveBtn.setEnabled(true);
		deleteBtn.setEnabled(true);
	}//end activateButton()

	private class InsertBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				String input = insertTxt.getText();
				String Name = input.split(":")[0];
				String Score = input.split(":")[1];
				double score1 = Double.parseDouble(Score.split(",")[0]);
				double score2 = Double.parseDouble(Score.split(",")[1]);
				AccountRecordSerializable newAccount = new AccountRecordSerializable(Name, score1,
						score2);
				mainTxt.append(String.format("%-30s\t%-15.1f\t%-15.1f\n",
						Name, score1, score2));
				insertTxt.setText("");
				accountSet.add(newAccount);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(FileAndLinkedList.this, "輸入的格式錯誤！請重新輸入",
						"警告", JOptionPane.ERROR_MESSAGE);
			}
		}
	}//end InsertBtnHandler

	private class DeleteBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {

			boolean isContain = false;
			String inputName = deleteTxt.getText();

			for (AccountRecordSerializable account : accountSet)
				if (account.getName().equals(inputName)) {
					accountSet.remove(account);
					isContain = true;
					break;
				}

			deleteTxt.setText("");
			mainTxt.setText("");

			for (AccountRecordSerializable account : accountSet)
				mainTxt.append(String.format("%-30s\t%-15.1f\t%-15.1f\n",
						account.getName(), account.getScore1(), account.getScore2()));

			if (!isContain)
				JOptionPane.showMessageDialog(FileAndLinkedList.this, "找不到此人名",
						"警告", JOptionPane.WARNING_MESSAGE);

		}
	}//end DeleteBtnHandler

	private class SaveBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			File save;
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showSaveDialog(FileAndLinkedList.this);

			if (result == JFileChooser.APPROVE_OPTION) {
				save = fileChooser.getSelectedFile();

				try {
					output = new ObjectOutputStream(new FileOutputStream(save));
				} // end try
				catch (FileNotFoundException exception) {
					JOptionPane.showMessageDialog(FileAndLinkedList.this, "檔案錯誤");
				} // end catch
				catch (IOException exception) {
					JOptionPane.showMessageDialog(FileAndLinkedList.this, "檔案錯誤");
				} // end catch

				try {
					for (AccountRecordSerializable record : accountSet)
						output.writeObject(record);

				} catch (IOException ioexception) {
					JOptionPane.showMessageDialog(FileAndLinkedList.this, "檔案錯誤");
				}
			} else {
				JOptionPane.showMessageDialog(FileAndLinkedList.this, "取消存檔");
			}

		}
	}//end SaveBtnHandler

	private class ClearBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			accountSet.clear();
			mainTxt.setText("");
		}
	}//end ClearBtnHandler
}
