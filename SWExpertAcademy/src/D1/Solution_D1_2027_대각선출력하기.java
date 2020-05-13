package D1;

import java.util.Arrays;

public class Solution_D1_2027_대각선출력하기 {

	public static void main(String[] args) {

		char[][] arr = new char[5][5];

		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], '+');
			for (int j = 0; j < arr[i].length; j++) {
				if (i == j) {
					arr[i][j] = '#';
				}
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
