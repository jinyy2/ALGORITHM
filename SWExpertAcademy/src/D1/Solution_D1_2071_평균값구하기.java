package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2071_평균값구하기 {
	static int T;
	static int sum;
	static double avg;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= T; i++) {
			sum = 0;
			String str = bf.readLine();
			String[] arr = str.split(" ");
			int len = arr.length;
			for (int j = 0; j < len; j++) {
				sum += Integer.parseInt(arr[j]);
			}
			avg = (1.0) * sum / len;
			System.out.printf("#%d %.0f\n", i, avg);
		}
	}
}