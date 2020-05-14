package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1984_중간평균값구하기 {
	static int T;
	static String[] arr;
	static int max;
	static int min;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			arr = br.readLine().trim().split(" ");
			sum = 0;

			for (int i = 0; i < arr.length; i++) {
				int tempI = Integer.parseInt(arr[i]);

				if (tempI < min) {
					min = tempI;
				}
				if (tempI > max) {
					max = tempI;
				}
				sum += tempI;
			}

			System.out.println("#" + test_case + " " + Math.round(1.0 * (sum - min - max) / (arr.length - 2)));
		}
	}
}
