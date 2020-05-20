package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3975_승률비교하기 {
	static int T;
	static int A, B, C, D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			System.out.print("#" + test_case + " ");
			if (A * D == B * C) {
				System.out.println("DRAW");
			} else if (A * D > B * C) {
				System.out.println("ALICE");
			} else if (A * D < B * C) {
				System.out.println("BOB");
			}
		}
	}
}
