
/* 102403015 資管3A 程祥恩 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MergeSortAnimation extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final int POINT_SPACE_LENGTH = 6;
	private static final int FRAME_WIDTH = 620;
	private static final int FRAME_HEIGHT = 700;
	private static final int ARRAY_SIZE = 100;

	public static Point[] points = new Point[ARRAY_SIZE];
	private JPanel drawarea;
	private JPanel buttonPanel;
	private JButton sortButton;
	private JButton shuffleButton;

	public static void main(String[] args)
	{
		MergeSortAnimation frame = new MergeSortAnimation();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public MergeSortAnimation()
	{ //建構GUI
		super("Merge Sort Animation");
		drawarea = new DrawArea();
		buttonPanel = new JPanel();
		sortButton = new JButton("Merge Sort");
		shuffleButton = new JButton("Shuffle");
		//drawarea.setBounds((400 - 100) / 2, 30, 100, 100); // 位置大小
		drawarea.setBackground(Color.WHITE);
		buttonPanel.add(sortButton);
		buttonPanel.add(shuffleButton);
		//add(shuffleButton, BorderLayout.SOUTH);
		add(buttonPanel, BorderLayout.SOUTH);
		add(drawarea, BorderLayout.CENTER);

		shuffleButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				points = createRandomArray();
				drawarea.repaint();
				sortButton.setEnabled(true);
			}
		});

		sortButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{ //按下後排序
				MergeSort(points);
				sortButton.setEnabled(false);
			}
		});

		points = createRandomArray();
		drawarea.repaint();
	}// end constructor

	public Point[] createRandomArray()
	{ //打亂陣列的function
		int temp; //製造亂數陣列時的暫存器
		int random = 0; //產生1~100亂數
		int[] value = new int[ARRAY_SIZE];
		Point[] array = new Point[ARRAY_SIZE];

		for (int i = 0; i < ARRAY_SIZE; i++)
			value[i] = i + 1;
		// 產生1~100

		for (int i = 0; i < array.length; i++)
		{ //依序把1~100放入陣列，同時打亂陣列
			random = (int) (Math.random() * 100);
			//產生1~i的亂數，避免ArrayOutOfBounds例外
			temp = value[random];
			value[random] = value[i];
			value[i] = temp;
		}

		for (int i = 0; i < ARRAY_SIZE; i++)
			array[i] = new Point(i, value[i]);
		//放入Point陣列
		return array;
	}

	public void MergeSort(Point[] A)
	{ //參考課本虛擬碼
		if (A.length > 1)
		{
			Point[] B;
			Point[] C;
			B = (A.length % 2 != 0 ? new Point[(A.length + 1) / 2] : new Point[A.length / 2]);
			// 若A陣列是奇數，那B陣列的大小就是(A+1)/2，防止因忽略餘數而失去的值
			C = new Point[A.length / 2];
			// c陣列的大小永遠如此，因為整數資料型別的除法會忽略小數點

			for (int i = 0; i < B.length; i++)
				B[i] = new Point(A[i].x, A[i].y);
			// A陣列的前面一半設給B陣列

			for (int j = B.length; j < A.length; j++)
				C[j - B.length] = new Point(A[j].x, A[j].y);
			// A陣列的後面一半設給C陣列

			MergeSort(B);
			MergeSort(C);
			Merge(B, C, A);
		}
	}//end MergeSort function

	public void Merge(Point[] B, Point[] C, Point[] A)
	{ //參考課本虛擬碼
		int i = 0, j = 0, k = 0, p = B.length, q = C.length;
		// i,j,k分別為陣列B,C,A的index

		while (i < p && j < q)
		{ //看B陣列與C陣列的第一個值誰小，較小值的所屬陣列派出下一個值繼續比
			if (B[i].y <= C[j].y)
				A[k++].y = B[i++].y;
			//B陣列的元素值較小，B派出下一個元素來和C陣列原先的值比大小
			else
				A[k++].y = C[j++].y;
			//C陣列的元素值較小，C派出下一個元素來和B陣列原先的值比大小
		} //end while

		if (i == p) //如果B陣列的值都比較完畢且放到A陣列了
			for (int x = j; x < q; x++)
				A[k++].y = C[x].y;
		//把C陣列剩下的值依序放入A陣列
		else //如果C陣列的值都比較完畢且放到A陣列了
			for (int x = i; x < p; x++)
				A[k++].y = B[x].y;
		//把B陣列剩下的值依序放入A陣列

		k = 0;
		for (int x = A[0].x; x <= A[A.length - 1].x; x++)
		{ //同步更新points陣列(要畫出來的點的陣列)
			points[x].y = A[k++].y;
			printPoints();
		}
	}//end Merge function

	public void printPoints()
	{
		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK); // 將舊畫面蓋掉;
		g2d.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		// 透過劃出黑色實心正方形將原本的畫面蓋掉
		g2d.setColor(Color.GREEN); // 設定點的顏色
		try
		{
			for (int i = 0; i < ARRAY_SIZE; i++)
			{ // 將points內的點全部畫出來
				g2d.fillOval(points[i].x * POINT_SPACE_LENGTH,
						FRAME_WIDTH - points[i].y * POINT_SPACE_LENGTH, 5, 5);
				// 透過fillOval來畫出點(直徑5的實心圓形)
			}
			Thread.sleep(10);
		} catch (Exception e)
		{
			e.getStackTrace();
		}
	}

	public class DrawArea extends JPanel
	{
		private static final long serialVersionUID = 1L;

		// 畫出每個點
		@Override
		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLACK); // 將舊畫面蓋掉;
			g2d.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
			// 透過劃出黑色實心正方形將原本的畫面蓋掉
			g2d.setColor(Color.GREEN); // 設定點的顏色
			try
			{
				for (int i = 0; i < ARRAY_SIZE; i++)
				{ // 將points內的點全部畫出來
					g2d.fillOval(points[i].x * POINT_SPACE_LENGTH,
							FRAME_WIDTH - points[i].y * POINT_SPACE_LENGTH, 5, 5);
					// 透過fillOval來畫出點(直徑5的實心圓形)
				}
			} catch (Exception e)
			{
				e.getStackTrace();
			}
		}
	} // end DrawArea
} //end ALHW1_3A_102403015
