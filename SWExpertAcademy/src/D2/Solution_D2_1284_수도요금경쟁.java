package D2;

import java.util.Scanner;

public class Solution_D2_1284_수도요금경쟁 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();

		for (int i = 1; i < cnt + 1; i++) {
			int min1 = 0;
			int min2 = 0;
			int min = 0;

			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();

			min1 = W * P;

			if (W <= R) {
				min2 = Q;
			} else {
				min2 = Q + (W - R) * S;
			}

			if (min1 < min2) {
				min = min1;
			} else {
				min = min2;
			}

			System.out.println("#" + i + " " + min);
		}

	}

}
