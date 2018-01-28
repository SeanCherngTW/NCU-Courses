import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class BinarySearchTree extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton insertNodeBtn, deleteNodeBtn, searchValueBtn, printTreeBtn, RebalanceTreeBtn, clearTreeBtn;
	private JTextField insertNodeTxt, deleteNodeTxt;
	private JTextArea printTxt;
	private JPanel toolPanel, printPanel;
	private JScrollPane printScroll;
	private Node root = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bst.setResizable(false);
		bst.setSize(800, 600);
		bst.setVisible(true);
	}

	public BinarySearchTree() {

		/* Tool Panel */
		insertNodeBtn = new JButton("Insert Node");
		deleteNodeBtn = new JButton("Delete Node");
		searchValueBtn = new JButton("Search Value");
		printTreeBtn = new JButton("Print Tree in ...");
		RebalanceTreeBtn = new JButton("");
		clearTreeBtn = new JButton("Clear Tree");
		insertNodeTxt = new JTextField();
		deleteNodeTxt = new JTextField();

		insertNodeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		deleteNodeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

		insertNodeBtn.addActionListener(new InsertNodeBtnHandler());
		deleteNodeBtn.addActionListener(new DeleteNodeBtnHandler());
		searchValueBtn.addActionListener(new SearchValueBtnHandler());
		printTreeBtn.addActionListener(new PrintTreeBtnHandler());
		clearTreeBtn.addActionListener(new ClearTreeBtnHandler());

		toolPanel = new JPanel();

		toolPanel.add(insertNodeTxt);
		toolPanel.add(insertNodeBtn);
		toolPanel.add(deleteNodeTxt);
		toolPanel.add(deleteNodeBtn);
		toolPanel.add(searchValueBtn);
		toolPanel.add(printTreeBtn);
		toolPanel.add(RebalanceTreeBtn);
		toolPanel.add(clearTreeBtn);

		toolPanel.setLayout(new GridLayout(2, 4, 0, 0));
		/* Tool Panel */

		/* Print Panel */
		printTxt = new JTextArea();
		printPanel = new JPanel();
		printScroll = new JScrollPane(printTxt);
		printTxt.setBackground(Color.WHITE);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		printTxt.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		printPanel.setLayout(new GridLayout(1, 1, 0, 0));
		printPanel.add(printScroll);
		/* Print Panel */

		/* Main Panel */
		add(toolPanel, BorderLayout.NORTH);
		add(printPanel, BorderLayout.CENTER);
		/* Main Panel */
	}

	private class InsertNodeBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				int newValue = Integer.parseInt(insertNodeTxt.getText());
				Node newNode = new Node(newValue);
				if (root == null) {
					root = newNode;
					printTxt.append(String.format("The node %d has been inserted\n", newNode.value));
					return;
				}
				Node currentNode = root;
				while (true) {
					if (newNode.value < currentNode.value) {
						if (currentNode.leftNode == null) {
							currentNode.leftNode = newNode;
							break;
						} else
							currentNode = currentNode.leftNode;
					} else {
						if (currentNode.rightNode == null) {
							currentNode.rightNode = newNode;
							break;
						} else
							currentNode = currentNode.rightNode;
					} // end outer if/else
				} // end while
				printTxt.append(String.format("The node %d has been inserted\n", newNode.value));
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(BinarySearchTree.this, "Please enter a digit!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} finally {
				insertNodeTxt.setText("");
				insertNodeTxt.requestFocus();
			} // end try
		} // end actionPerformed()
	}// end InsertNodeBtnHandler

	private class DeleteNodeBtnHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				int deleteValue = Integer.parseInt(deleteNodeTxt.getText());
				if (root == null) {
					JOptionPane.showMessageDialog(BinarySearchTree.this, "The tree is empty!", "Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				Node currentNode = root;
				Node parentNode = root;
				boolean isParentsLeftChild = false;
				while (deleteValue != currentNode.value) {
					parentNode = currentNode;
					if (deleteValue < currentNode.value) {
						currentNode = currentNode.leftNode;
						isParentsLeftChild = true;
					} else {
						currentNode = currentNode.rightNode;
						isParentsLeftChild = false;
					}
					if (currentNode == null) {
						printTxt.append(String.format("Value %d is not exist!\n", deleteValue));
						return;
					} // end if
				} // end while

				if (currentNode.leftNode == null && currentNode.rightNode == null) {
					if (currentNode == root)
						root = null;
					else if (isParentsLeftChild)
						parentNode.leftNode = null;
					else
						parentNode.rightNode = null;
				} // end outer if

				if (currentNode.leftNode != null && currentNode.rightNode == null) {
					if (currentNode == root)
						root = currentNode.leftNode;
					else if (isParentsLeftChild)
						parentNode.leftNode = currentNode.leftNode;
					else
						parentNode.rightNode = currentNode.leftNode;
				} // end outer if

				if (currentNode.leftNode == null && currentNode.rightNode != null) {
					if (currentNode == root)
						root = currentNode.rightNode;
					else if (isParentsLeftChild)
						parentNode.leftNode = currentNode.rightNode;
					else
						parentNode.rightNode = currentNode.rightNode;
				} // end outer if

				if (currentNode.leftNode != null && currentNode.rightNode != null) {
					Node minNode = null;
					Node minParent = null;
					Node current = currentNode.rightNode;

					while (current != null) {
						minParent = minNode;
						minNode = current;
						current = current.leftNode;
					}

					minNode.leftNode = currentNode.leftNode;

					if (currentNode.rightNode != minNode) {
						minParent.leftNode = minNode.rightNode;
						minNode.rightNode = currentNode.rightNode;
					}

					if (currentNode == root)
						root = minNode;
					else if (isParentsLeftChild)
						parentNode.leftNode = minNode;
					else
						parentNode.rightNode = minNode;
				} // end outer if

				printTxt.append(String.format("The node %d has been deleted\n", deleteValue));

			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(BinarySearchTree.this, "Please enter a digit!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} finally {
				deleteNodeTxt.setText("");
				deleteNodeTxt.requestFocus();
			} // end try
		} // end actionPerformed()
	} // end deleteNodeBtnHandler

	private class SearchValueBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				if (root == null) {
					JOptionPane.showMessageDialog(BinarySearchTree.this, "The tree is empty!", "Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				int searchValue = Integer.parseInt((JOptionPane.showInputDialog(BinarySearchTree.this,
						"Enter a value to search", "Search", JOptionPane.QUESTION_MESSAGE)));
				Node currentNode = root;
				String Route = String.valueOf(root.value);
				while (true) {
					int difference = searchValue - currentNode.value;
					if (difference == 0) { // Find the value
						printTxt.append(String.format("Search Value: %d (Root) %s (Leaf)\n", searchValue, Route));
						break;
					}
					if (difference < 0) {
						if (currentNode.leftNode == null) {
							printTxt.append(String.format("Value %d is not exist!\n", searchValue));
							break;
						} else {
							Route += " --> " + currentNode.leftNode.value;
							currentNode = currentNode.leftNode;
						}
					}
					if (difference > 0) {
						if (currentNode.rightNode == null) {
							printTxt.append(String.format("Value %d is not exist!\n", searchValue));
							break;
						} else {
							Route += " --> " + currentNode.rightNode.value;
							currentNode = currentNode.rightNode;
						}
					} // end outer if/else
				} // end while
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(BinarySearchTree.this, "Please enter a digit!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} finally {
				insertNodeTxt.setText("");
				insertNodeTxt.requestFocus();
			}
		} // end actionPerformed()
	} // end SearchValueBtnHandler

	private class PrintTreeBtnHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (root == null) {
				JOptionPane.showMessageDialog(BinarySearchTree.this, "The tree is empty!", "Warning",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			String[] TraversalList = { "preorder", "inorder", "postorder", "levelorder" };
			String Traversal = (String) JOptionPane.showInputDialog(BinarySearchTree.this, "How to Traversal the tree?",
					"Input", JOptionPane.INFORMATION_MESSAGE, null, TraversalList, "preorder");
			Node currentNode = root;
			switch (Traversal) {
			case "preorder":
				printTxt.append("Traversal in pre-order: ");
				preorder(currentNode);
				printTxt.append("\n");
				break;
			case "inorder":
				printTxt.append("Traversal in in-order: ");
				inorder(currentNode);
				printTxt.append("\n");
				break;
			case "postorder":
				printTxt.append("Traversal in post-order: ");
				postorder(currentNode);
				printTxt.append("\n");
				break;
			case "levelorder":
				printTxt.append("Traversal in level-order: ");
				levelorder(currentNode);
				printTxt.append("\n");
				break;
			}
		} // end actionPerformed()

		private void preorder(Node startNode) {
			printTxt.append(startNode.value + " ");
			if (startNode.leftNode != null)
				preorder(startNode.leftNode);
			if (startNode.rightNode != null)
				preorder(startNode.rightNode);
			return;
		} // end preorder()

		private void inorder(Node startNode) {
			if (startNode.leftNode != null)
				inorder(startNode.leftNode);
			printTxt.append(startNode.value + " ");
			if (startNode.rightNode != null)
				inorder(startNode.rightNode);
			return;
		} // end inorder()

		private void postorder(Node startNode) {
			if (startNode.leftNode != null)
				postorder(startNode.leftNode);
			if (startNode.rightNode != null)
				postorder(startNode.rightNode);
			printTxt.append(startNode.value + " ");
			return;
		} // end postorder()

		private void levelorder(Node startNode) {
			Queue<Node> queue = new LinkedList<Node>();
			if (root == null) {
				JOptionPane.showMessageDialog(BinarySearchTree.this, "The tree is empty!", "Warning",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			queue.offer(root);
			while (!queue.isEmpty()) {
				Node currentNode = queue.poll();
				printTxt.append(currentNode.value + " ");
				if (currentNode.leftNode != null)
					queue.offer(currentNode.leftNode);
				if (currentNode.rightNode != null)
					queue.offer(currentNode.rightNode);
			} // end while
		} // end levelorder()
	} // end PrintTreeBtnHandler

	private class ClearTreeBtnHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (root == null) {
				JOptionPane.showMessageDialog(BinarySearchTree.this, "The tree is empty!", "Warning",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			int result = JOptionPane.showConfirmDialog(BinarySearchTree.this, "Clear the tree?", "Confirm",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (result == JOptionPane.OK_OPTION) {
				root = null;
				JOptionPane.showMessageDialog(BinarySearchTree.this, "The tree has beed cleared!", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				printTxt.setText("");
			}
		} // end actionPerformed()
	} // end ClearTreeBtnHandler
} // end BinartSearchTree