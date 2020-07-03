package D3;

import java.util.Scanner;

public class Solution_D3_9229_한빈이와SpotMart {
	static int T, N, M;
	static int[] bag;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			N = sc.nextInt();
			M = sc.nextInt();
			max = -1;

			bag = new int[N];
			for (int i = 0; i < N; i++) {
				bag[i] = sc.nextInt();
			}
			for (int x = 0; x < N; x++) {
				for (int y = x + 1; y < N; y++) {
					if (max <= bag[x] + bag[y] && bag[x] + bag[y] <= M) {
						max = bag[x] + bag[y];
					}
				}
			}
			System.out.println("#" + iT + " " + max);
		}
	}
}
