package SW;

import java.util.Scanner;

public class Solution_SW_1210_Ladder1 {

	static int T;
	static int N;
	static int[][] ladder;

	// 방향을 먼저 설정함
//		static int[] dy = {0,0,-1};
//		static int[] dx = {1,-1,0}; //-> <- ^
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//			T = sc.nextInt();
		// 1부터 test개수까지
		for (int t = 1; t <= 10; t++) {
			// 배열의 크기 100
			sc.nextInt();
			N = 100;
			// 100*100으로 배열 초기화
			ladder = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 배열에 101010 값 받음
					ladder[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				if (ladder[99][i] == 2) { // 57
					int y = 99, x = i;
					while (y != 0) {
						// 왼쪽 && 왼쪽 넘어가지 않게 함
						if (x - 1 >= 0 && ladder[y][x - 1] == 1) {
							ladder[y][x] = 0;
							x -= 1;
						}
						// 오른쪽 && 오른쪽 넘어가지 않게 함
						else if (x + 1 < N && ladder[y][x + 1] == 1) {
							ladder[y][x] = 0;
							x += 1;

							// 갈 수 있는지
						} else if (ladder[y - 1][x] == 1 && y - 1 >= 0) {
							y -= 1;
						}

					}
					System.out.println("#" + t + " " + x);
				}

			}
		}
	}
}
