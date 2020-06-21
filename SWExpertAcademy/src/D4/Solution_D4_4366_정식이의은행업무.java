package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_4366_정식이의은행업무 {

	static String num1, num2;
	static char[] temp1, temp2;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			num1 = br.readLine();
			num2 = br.readLine();
			result = 0;

			for (int j = num2.length() - 1; j >= 0; j--) {
				temp2 = num2.toCharArray();
				int bbb;
				temp2[j] = '2';
				bbb = change(temp2, 3);
				method1(bbb);
				temp2[j] = '1';
				bbb = change(temp2, 3);
				method1(bbb);
				temp2[j] = '0';
				bbb = change(temp2, 3);
				method1(bbb);
			}

			System.out.println("#" + test_case + " " + result);

		}
	}

	private static void method1(int b) {
		for (int i = num1.length() - 1; i >= 0; i--) {
			temp1 = num1.toCharArray();
			if (temp1[i] == '0')
				temp1[i] = '1';
			else if (temp1[i] == '1')
				temp1[i] = '0';

			int aaa = change(temp1, 2);
			if (aaa == b) {
				result = aaa;
				return;
			}

		}
	}

	private static int change(char[] pr, int k) {
		String temp = "";
		for (int i = 0; i < pr.length; i++) {
			temp += pr[i];
		}
		return Integer.parseInt(temp, k);
	}

}
