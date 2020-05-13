package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2068_최대수구하기 {
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			String str = bf.readLine();
			String arr[] = str.split(" ");
			int max = 0;
			for (int j = 0; j < arr.length; j++) {
				if (max < Integer.parseInt(arr[j])) {
					max = Integer.parseInt(arr[j]);
				}
			}
			System.out.println("#" + (i + 1) + " " + max);
		}
	}
}
