package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_3376_파도반수열 {
	static int T, N;
	static long[] tri;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			tri = new long[101];
			tri[0] = 1;
			tri[1] = 1;
			tri[2] = 1;
			tri[3] = 2;
			tri[4] = 2;
			for (int i = 5; i < tri.length; i++) {
				tri[i] = tri[i - 1] + tri[i - 5];
				// 1 1 1 2 2 3 4 5 7(5+2) 9(7+2) 12(9+3) 16(12+4) 21(16+5) 28(21+7)
			}
			System.out.println("#" + test_case + " " + tri[N-1]);
		}
	}
}
