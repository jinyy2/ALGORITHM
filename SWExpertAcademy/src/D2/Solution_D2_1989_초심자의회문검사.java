package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1989_초심자의회문검사 {
	static int T, result;
	static String word;
	static String word_reverse;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			word = br.readLine();
			word_reverse = "";
			for (int i = word.length() - 1; i >= 0; i--) {
				word_reverse += word.charAt(i);
			}
			if (word.equals(word_reverse)) {
				result = 1;
			} else {
				result = 0;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
