package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_8659_GCD {
	static int T;
	static int K;
	static long[] pbn;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		pbn = new long[92];
		pbn[0] = 1;
		pbn[1] = 1;
		pbn[2] = 2;

		for (int i = 3; i < pbn.length; i++) {
			pbn[i] = pbn[i - 1] + pbn[i - 2];
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			K = Integer.parseInt(br.readLine());
			System.out.println("#" + test_case + " " + pbn[K + 1] + " " + pbn[K]);
		}
	}
}