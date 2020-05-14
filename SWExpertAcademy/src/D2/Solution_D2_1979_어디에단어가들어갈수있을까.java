package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1979_어디에단어가들어갈수있을까 {
	static int T, N, K;
	static int[][] map;
	static int count, cnt, cnt2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			count = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - K; j++) {
					if (map[i][j] == 1) {
						boolean check = false;
						for (int j2 = 0; j2 < K; j2++) {
							if (map[i][j + j2] == 1) {
								check = true;
							} else {
								check = false;
								break;
							}
						}
						if (j + K < N && map[i][j + K] != 0) {
							check = false;
						}
						if (j != 0 && map[i][j - 1] != 0) {
							check = false;
						}
						if (check) {
							count++;
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - K; j++) {
					if (map[j][i] == 1) {
						boolean check = false;
						for (int j2 = 0; j2 < K; j2++) {
							if (map[j + j2][i] == 1) {
								check = true;
							} else {
								check = false;
								break;
							}
						}
						if (j + K < N && map[j + K][i] != 0) {
							check = false;
						}
						if (j != 0 && map[j - 1][i] != 0) {
							check = false;
						}
						if (check) {
							count++;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + count);
		}
	}
}
