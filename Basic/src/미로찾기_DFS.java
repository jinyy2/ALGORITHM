import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* input-data
5 5
#S###
#...#
#.#.#
#....
###G#
*/
public class 미로찾기_DFS {
	static int H, W;
	static char[][] map;
	static int[][] visited;
	static int sr, sc, er, ec;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visited = new int[H][W];

		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'S') {
					sr = i;
					sc = j;
					visited[sr][sc] = 1;
				} else if (map[i][j] == 'G') {
					er = i;
					ec = j;
				}
			}
		}
		min = Integer.MAX_VALUE;

		dfs(sr, sc, 0);

		System.out.println(min);
	}

	private static void dfs(int r, int c, int count) {
		if (r == er && c == ec) {
			min = Math.min(min, count);
			print(visited);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!safe(nr, nc))
				continue;

			if (visited[nr][nc] == 0 && (map[nr][nc] == '.' || map[nr][nc] == 'G')) {
				visited[nr][nc] = 1;
				dfs(nr, nc, count + 1);
				visited[nr][nc] = 0;
			}
		}

	}

	private static boolean safe(int nr, int nc) {

		return nr >= 0 && nc >= 0 && nr < H && nc < W;
	}

	private static void print(int[][] pr) {
		for (int[] p : pr) {
			System.out.println(Arrays.toString(p));
		}
		System.out.println();
	}
}
