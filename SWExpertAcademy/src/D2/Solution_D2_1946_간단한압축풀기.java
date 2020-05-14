package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1946_간단한압축풀기 {
	static int T, N;
	static String ch;
	static String str;
	static String arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			str = "";
			for (int j = 0; j < N; j++) {
				ch = br.readLine();
				arr = ch.split(" ");
				for (int k = 0; k < Integer.parseInt(arr[1]); k++) {
					str += arr[0];
				}
			}
			int len = str.length();
			int c = 0;
			System.out.println("#" + (i + 1));
			for (int k = 0; k < (len / 10) + 1; k++) {
				if (str.length() - c >= 10) {
					System.out.print(str.substring(c, c + 10));
					c += 10;
				} else {
					System.out.print(str.substring(c, str.length()));
				}
				System.out.println();
			}

		}
	}
}
