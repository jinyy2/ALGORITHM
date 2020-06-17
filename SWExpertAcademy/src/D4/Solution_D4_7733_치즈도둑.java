package D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7733_치즈도둑 {
	static int T, N;
	static int[][] map;
	static int[][] check;
	static int[][] checkReverse;
	static boolean[] day;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int max;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new int[N][N];

			day = new boolean[101];
			max = 1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					day[map[i][j]] = true;
				}
			}

			for (int i = 1; i < day.length; i++) {
				count = 0;

				if (day[i]) {
					// 함수만들어라 이놈아
					for (int j = 0; j < N; j++) {
						for (int j2 = 0; j2 < N; j2++) {
							if (map[j][j2] == i) {
								check[j][j2] = 1;
							}
						}
					}
					checkReverse = new int[N][N];
					for (int j = 0; j < N; j++) {
						for (int j2 = 0; j2 < N; j2++) {
							if (check[j][j2] == 0) {
								checkReverse[j][j2] = 1;
							} else if (check[j][j2] == 1) {
								checkReverse[j][j2] = 0;
							}
						}
					}
					int cnt = 0;
					for (int j = 0; j < N; j++) {
						for (int j2 = 0; j2 < N; j2++) {
							if (checkReverse[j][j2] == 1) {
								cnt++; // 굴 1 2, 3, 4
								godfs(j, j2, cnt + 1);
							}
						}
					}
					if (cnt > max) {
						max = cnt;
					}
//						if(count > max) {
//							max = count; 
//						}
//						System.out.println("DAY - "+i+"---------------------");
//						print(check);
//						System.out.println("DAY - "+i+" checkReverse---------------------");
//						print(checkReverse);

				}

			}
//				print(map);
			System.out.println("#" + test_case + " " + max);
		}
	}

	private static void godfs(int y, int x, int c) {
		checkReverse[y][x] = c;
		for (int d = 0; d < 4; d++) {
			if (safe(y + dy[d], x + dx[d]) && checkReverse[y + dy[d]][x + dx[d]] == 1) {// 위
				godfs(y + dy[d], x + dx[d], c);
			}
		}
	}

	public static boolean safe(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N) {
			return true;
		} else {
			return false;
		}
	}

	private static void print(int[][] prArr) {
		for (int i = 0; i < prArr.length; i++) {
			for (int j = 0; j < prArr[i].length; j++) {
				System.out.print(prArr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
