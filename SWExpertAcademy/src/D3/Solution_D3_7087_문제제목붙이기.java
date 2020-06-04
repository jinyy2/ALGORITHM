package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_7087_문제제목붙이기 {
	static int T, N;
	static boolean[] alphabet;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			alphabet = new boolean[26];
			N = Integer.parseInt(br.readLine());
			result = 0;

			for (int i = 0; i < N; i++) {
				alphabet[(int) br.readLine().charAt(0) - 65] = true;
			}
			for (int i = 0; i < alphabet.length; i++) {
				if (alphabet[i]) {
					result = i + 1;
				} else if (!alphabet[i]) {
					break;
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}