package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_2007_패턴마다의길이 {
	static int T;
	static String[] arr;
	static String[] arr2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			String str = bf.readLine();
			String word = "";
			for (int k = 1; k < 10; k++) {
				String str2 = str.substring(0, k);
				if (str2.equals(str.substring(k, k + str2.length()))) {
					word = str2;
					break;
				}

			}
			System.out.println("#" + (i + 1) + " " + word.length());

		}
	}
}
