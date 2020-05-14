package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1974_스도쿠검증 {
	static int T;
	static int count;
	static int sum_square;
	static int sum_square_count;
	static String[][] arr = new String[9][9];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			sum_square_count = 0;
			for (int j = 0; j < 9; j++) {
				String str = bf.readLine();
				arr[j] = str.split(" ");
			}
			count = 0;
			for (int y = 0; y < 9; y++) {
				int sum_row = 0;
				int sum_col = 0;
				for (int x = 0; x < 9; x++) {
					sum_row += Integer.parseInt(arr[y][x]);
					sum_col += Integer.parseInt(arr[x][y]);
				}
				if (sum_row == 45 && sum_col == 45) {
					count++;
				}
			}
			sum_square_count += square(0, 3, 0, 3);
			sum_square_count += square(0, 3, 3, 6);
			sum_square_count += square(0, 3, 6, 9);
			sum_square_count += square(3, 6, 0, 3);
			sum_square_count += square(3, 6, 3, 6);
			sum_square_count += square(3, 6, 6, 9);
			sum_square_count += square(6, 9, 0, 3);
			sum_square_count += square(6, 9, 3, 6);
			sum_square_count += square(6, 9, 6, 9);

			if (count == 9 && sum_square_count == 9) {
				System.out.println("#" + (i + 1) + " 1");
			} else {
				System.out.println("#" + (i + 1) + " 0");
			}
		}
	}

	public static int square(int i, int i1, int j, int j1) {
		sum_square = 0;
		for (int y = i; y < i1; y++) {
			for (int x = j; x < j1; x++) {
				sum_square += Integer.parseInt(arr[y][x]);
			}
		}
		if (sum_square == 45) {
			return 1;
		} else {
			return 0;
		}
	}
}
