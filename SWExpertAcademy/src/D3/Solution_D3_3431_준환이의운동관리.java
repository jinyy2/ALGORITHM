package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3431_준환이의운동관리 {
	static int T, L, U, X;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			U = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			result = 0;

			if (X < L) {
				result = L - X;
			} else if (X >= L && X <= U) {
				result = 0;
			} else {
				result = -1;
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}
