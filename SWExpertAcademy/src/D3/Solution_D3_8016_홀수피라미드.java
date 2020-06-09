package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_8016_홀수피라미드 {
	static int T;
	static long N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()) - 1;
			long first = 1;
			long last = 1;

			first += 4 * (N * (N - 1) / 2) + 2 * N;
			last += 4 * (N * (N - 1) / 2) + 6 * N;

			// first = 2+(n-1)*4
			// last == 6+(n-1)*4

			System.out.println("#" + test_case + " " + first + " " + last);
		}
	}
}
