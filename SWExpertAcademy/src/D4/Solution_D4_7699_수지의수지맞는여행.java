package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행 {
	static int T;
	static char[][] map;
	static boolean[] alphabet;
	static int ans;
	static int R, C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			alphabet = new boolean[26];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			ans = 0; // 명물 최대치
			alphabet[map[0][0] - 'A'] = true;
			dfs(0, 0, 1);
			System.out.println("#" + test_case + " " + ans);
		}
	}

	static int[] dy = { 0, 0, 1, -1 }; // 우 좌 하 상
	static int[] dx = { 1, -1, 0, 0 };

	public static void dfs(int y, int x, int cnt) {
		if (cnt == 26) {
			ans = cnt;
			return;
		}
		if (ans < cnt) {
			ans = cnt;
		}
		alphabet[map[y][x] - 'A'] = true;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny >= 0 && ny < R && nx >= 0 && nx < C && !alphabet[map[ny][nx] - 'A']) {
				dfs(ny, nx, cnt + 1);
			}
		}
		alphabet[map[y][x] - 'A'] = false;
	}
}