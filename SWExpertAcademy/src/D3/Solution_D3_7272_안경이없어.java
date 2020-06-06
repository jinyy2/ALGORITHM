package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7272_안경이없어 {
	static String result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		String arr = "CEFGHIJKLMNSTUVWXYZ";
		String arr2 = "ADOPQR";

		for (int test_case = 1; test_case <= T; test_case++) {
			result = "";
			st = new StringTokenizer(br.readLine());
			String[] word1 = st.nextToken().split("");
			String[] word2 = st.nextToken().split("");

			if (word1.length != word2.length) {
				result = "DIFF";
			} else {
				for (int i = 0; i < word1.length; i++) {
					if (arr.contains(word1[i]) && arr.contains(word2[i])) {
						result = "SAME";
						continue;
					} else if (arr2.contains(word1[i]) && arr2.contains(word2[i])) {
						result = "SAME";
						continue;
					} else if (word1[i].equals("B") && word2[i].equals("B")) {
						result = "SAME";
						continue;
					} else {
						result = "DIFF";
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
