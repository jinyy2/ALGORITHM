package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_4406_모음이보이지않는사람 {
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			str = str.replaceAll("a", "");
			str = str.replaceAll("e", "");
			str = str.replaceAll("i", "");
			str = str.replaceAll("o", "");
			str = str.replaceAll("u", "");

			System.out.println("#" + test_case + " " + str);
		}
	}
}
