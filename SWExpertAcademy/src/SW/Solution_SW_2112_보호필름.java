package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_2112_보호필름 {

	static int T;
	static int D, W, K;
	static int[][] map;
	static int[] a0, a1;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			a0 = new int[W];
			a1 = new int[W];
			Arrays.fill(a1, 1);

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = -1;
			for (int i = 0; i <= K; i++) {
				dfs(0, 0, i);
				if (result != -1) {
					break;
				}
			}
			System.out.println("#" + test_case + " " + result);
		}

	}

	private static void dfs(int cnt, int dindex, int k) {
		if (result != -1) {
			return;
		}
		if (cnt == k) {
			if (check()) {
				result = k;
			}
			return;
		}
		if (dindex == D) {
			return;
		}
		int[] temp = new int[W];
		System.arraycopy(map[dindex], 0, temp, 0, W);
		System.arraycopy(a0, 0, map[dindex], 0, W);
		dfs(cnt + 1, dindex + 1, k);
		System.arraycopy(a1, 0, map[dindex], 0, W);
		dfs(cnt + 1, dindex + 1, k);
		System.arraycopy(temp, 0, map[dindex], 0, W);
		dfs(cnt, dindex + 1, k);

	}

	private static boolean check() {
		for (int j = 0; j < W; j++) {
			int cnt = 1;
			for (int i = 1; i < D; i++) {
				if (map[i - 1][j] == map[i][j]) {
					cnt++;

				} else {
					cnt = 1;
				}
				if (cnt == K) {
					break;
				}
			}
			if (cnt < K) {
				return false;
			}
		}
		return true;
	}

}
