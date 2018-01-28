
/* 102403015 ���3A �{���� */

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
	{ //�غcGUI
		super("Merge Sort Animation");
		drawarea = new DrawArea();
		buttonPanel = new JPanel();
		sortButton = new JButton("Merge Sort");
		shuffleButton = new JButton("Shuffle");
		//drawarea.setBounds((400 - 100) / 2, 30, 100, 100); // ��m�j�p
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
			{ //���U��Ƨ�
				MergeSort(points);
				sortButton.setEnabled(false);
			}
		});

		points = createRandomArray();
		drawarea.repaint();
	}// end constructor

	public Point[] createRandomArray()
	{ //���ð}�C��function
		int temp; //�s�y�üư}�C�ɪ��Ȧs��
		int random = 0; //����1~100�ü�
		int[] value = new int[ARRAY_SIZE];
		Point[] array = new Point[ARRAY_SIZE];

		for (int i = 0; i < ARRAY_SIZE; i++)
			value[i] = i + 1;
		// ����1~100

		for (int i = 0; i < array.length; i++)
		{ //�̧ǧ�1~100��J�}�C�A�P�ɥ��ð}�C
			random = (int) (Math.random() * 100);
			//����1~i���üơA�קKArrayOutOfBounds�ҥ~
			temp = value[random];
			value[random] = value[i];
			value[i] = temp;
		}

		for (int i = 0; i < ARRAY_SIZE; i++)
			array[i] = new Point(i, value[i]);
		//��JPoint�}�C
		return array;
	}

	public void MergeSort(Point[] A)
	{ //�Ѧҽҥ������X
		if (A.length > 1)
		{
			Point[] B;
			Point[] C;
			B = (A.length % 2 != 0 ? new Point[(A.length + 1) / 2] : new Point[A.length / 2]);
			// �YA�}�C�O�_�ơA��B�}�C���j�p�N�O(A+1)/2�A����]�����l�Ʀӥ��h����
			C = new Point[A.length / 2];
			// c�}�C���j�p�û��p���A�]����Ƹ�ƫ��O�����k�|�����p���I

			for (int i = 0; i < B.length; i++)
				B[i] = new Point(A[i].x, A[i].y);
			// A�}�C���e���@�b�]��B�}�C

			for (int j = B.length; j < A.length; j++)
				C[j - B.length] = new Point(A[j].x, A[j].y);
			// A�}�C���᭱�@�b�]��C�}�C

			MergeSort(B);
			MergeSort(C);
			Merge(B, C, A);
		}
	}//end MergeSort function

	public void Merge(Point[] B, Point[] C, Point[] A)
	{ //�Ѧҽҥ������X
		int i = 0, j = 0, k = 0, p = B.length, q = C.length;
		// i,j,k���O���}�CB,C,A��index

		while (i < p && j < q)
		{ //��B�}�C�PC�}�C���Ĥ@�ӭȽ֤p�A���p�Ȫ����ݰ}�C���X�U�@�ӭ��~���
			if (B[i].y <= C[j].y)
				A[k++].y = B[i++].y;
			//B�}�C�������ȸ��p�AB���X�U�@�Ӥ����өMC�}�C������Ȥ�j�p
			else
				A[k++].y = C[j++].y;
			//C�}�C�������ȸ��p�AC���X�U�@�Ӥ����өMB�}�C������Ȥ�j�p
		} //end while

		if (i == p) //�p�GB�}�C���ȳ���������B���A�}�C�F
			for (int x = j; x < q; x++)
				A[k++].y = C[x].y;
		//��C�}�C�ѤU���Ȩ̧ǩ�JA�}�C
		else //�p�GC�}�C���ȳ���������B���A�}�C�F
			for (int x = i; x < p; x++)
				A[k++].y = B[x].y;
		//��B�}�C�ѤU���Ȩ̧ǩ�JA�}�C

		k = 0;
		for (int x = A[0].x; x <= A[A.length - 1].x; x++)
		{ //�P�B��spoints�}�C(�n�e�X�Ӫ��I���}�C)
			points[x].y = A[k++].y;
			printPoints();
		}
	}//end Merge function

	public void printPoints()
	{
		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK); // �N�µe���\��;
		g2d.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		// �z�L���X�¦��ߥ���αN�쥻���e���\��
		g2d.setColor(Color.GREEN); // �]�w�I���C��
		try
		{
			for (int i = 0; i < ARRAY_SIZE; i++)
			{ // �Npoints�����I�����e�X��
				g2d.fillOval(points[i].x * POINT_SPACE_LENGTH,
						FRAME_WIDTH - points[i].y * POINT_SPACE_LENGTH, 5, 5);
				// �z�LfillOval�ӵe�X�I(���|5����߶��)
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

		// �e�X�C���I
		@Override
		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLACK); // �N�µe���\��;
			g2d.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
			// �z�L���X�¦��ߥ���αN�쥻���e���\��
			g2d.setColor(Color.GREEN); // �]�w�I���C��
			try
			{
				for (int i = 0; i < ARRAY_SIZE; i++)
				{ // �Npoints�����I�����e�X��
					g2d.fillOval(points[i].x * POINT_SPACE_LENGTH,
							FRAME_WIDTH - points[i].y * POINT_SPACE_LENGTH, 5, 5);
					// �z�LfillOval�ӵe�X�I(���|5����߶��)
				}
			} catch (Exception e)
			{
				e.getStackTrace();
			}
		}
	} // end DrawArea
} //end ALHW1_3A_102403015
