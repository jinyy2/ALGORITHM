import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/* input-data
7
0 1 1 0 1 0 0
0 1 1 0 1 0 1
1 1 1 0 1 0 1
0 0 0 0 1 1 1
0 1 0 0 0 0 0
0 1 1 1 1 1 0
0 1 1 1 0 0 0
*/

public class Main_2667_단지번호붙이기 {

	static int N;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = c[j] - '0';
			}
		} // input-end
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					dfs(i, j, cnt + 1);
				}
			}
		}
		// 크기 구하기
		int[] count = new int[2 + cnt];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count[map[i][j]]++;
			}
		}
		List<Integer> list = new LinkedList<>();

		System.out.println(cnt);

		for (int k = 2; k < cnt + 2; k++) {
			if (count[k] != 0)
				list.add(count[k]);
		}
		list.sort(null);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static void dfs(int r, int c, int group) {
		map[r][c] = group;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!safe(nr, nc))
				continue;
			if (map[nr][nc] == 1) {
				dfs(nr, nc, group);
			}
		}
	}

	private static boolean safe(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}

}
