package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1976_시각덧셈 {
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			String str = bf.readLine();
			String[] arr = str.split(" ");
			int hour = Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);
			int min = Integer.parseInt(arr[1]) + Integer.parseInt(arr[3]);
			if (min >= 60) {
				hour += 1;
				min -= 60;
			}
			if (hour > 12) {
				hour -= 12;
			}
			System.out.println("#" + (i + 1) + " " + hour + " " + min);
		}
	}
}
