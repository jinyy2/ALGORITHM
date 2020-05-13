package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2070_큰놈작은놈같은놈 {
	static int T;
	static String str;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			str = bf.readLine();
			String arr[] = str.split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			if (a > b) {
				System.out.println("#" + (i + 1) + " >");
			} else if (a == b) {
				System.out.println("#" + (i + 1) + " =");
			} else if (a < b) {
				System.out.println("#" + (i + 1) + " <");
			}
		}
	}
}