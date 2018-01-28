public class MagicSquare {
	static void printSquare(int n) {
		int[][] arr = new int[n][n];
		int row = 0;
		int preRow, preColumn;
		int column = (n - 1) / 2;
		arr[row][column] = 1;

		for (int i = 2; i <= n * n; i++) {
			preRow = row;
			preColumn = column;

			row = ((row - 1 < 0) ? row = n - 1 : row - 1);
			column = ((column - 1 < 0) ? column = n - 1 : column - 1);

			if (arr[row][column] != 0) {
				column = preColumn;
				row = ((preRow + 1 > n - 1) ? 0 : preRow + 1);
				arr[row][column] = i;
			} else
				arr[row][column] = i;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%2d" + " ", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i = i + 2)
			printSquare(i);
	}
}
