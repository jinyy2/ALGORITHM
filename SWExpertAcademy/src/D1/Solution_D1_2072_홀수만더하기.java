package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2072_홀수만더하기 {
	static int T;
	static int sum;
	static int[] arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			sum = 0;
			String num = bf.readLine();
			String[] arr = num.split(" ");
			for (int j = 0; j < arr.length; j++) {
				if (Integer.parseInt(arr[j]) % 2 == 1) {
					sum += Integer.parseInt(arr[j]);
				}
			}
			System.out.println("#" + (i + 1) + " " + sum);
		}
	}
}