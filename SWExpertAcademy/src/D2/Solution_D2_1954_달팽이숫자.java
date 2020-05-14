package D2;

import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {

	static int T;
	static int N;
	static int[][] snail;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			snail = new int[N][N];
			int d = 0; // direnction -->
			int y = 0, x = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					snail[y][x] = i * N + j + 1; // 알칼제이
					if (d == 0) {
						// 오른쪽으로 넘어가지 않거나
						if (x + 1 < N && snail[y][x + 1] == 0) {
							x++;
						} else {
							d = 1; // V
							y++;
						}
					} else if (d == 1) {
						// 오른쪽으로 넘어가지 않거나
						if (y + 1 < N && snail[y + 1][x] == 0) {
							y++;
						} else {
							d = 2; // <
							x--;
						}
					} else if (d == 2) {
						// 오른쪽으로 넘어가지 않거나
						if (x - 1 >= 0 && snail[y][x - 1] == 0) {
							x--;
						} else {
							d = 3; // ^
							y--;
						}
					} else if (d == 3) {
						// 오른쪽으로 넘어가지 않거나
						if (y - 1 >= 0 && snail[y - 1][x] == 0) {
							y--;
						} else {
							d = 0; // >
							x++;
						}
					}

				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
