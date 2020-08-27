import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* input-data
5 5
#S###
#...#
#.#.#
#....
###G#
*/
class Point {
	int r;
	int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class 미로찾기_BFS {

	static int H, W;
	static char[][] map;
	static int[][] visited;
	static int sr, sc, er, ec;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

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
				} else if (map[i][j] == 'G') {
					er = i;
					ec = j;
				}
			}
		}
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(sr, sc));
		visited[sr][sc] = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int r = cur.r;
			int c = cur.c;

			if (r == er && c == ec) {
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!safe(nr, nc))
					continue;
				if (visited[nr][nc] == 0 && (map[nr][nc] == '.' || map[nr][nc] == 'G')) {
					visited[nr][nc] = visited[r][c] + 1;
					queue.offer(new Point(nr, nc));
				}

			}
		}
//		print(map);
		print(visited);
		System.out.println(visited[er][ec]);
	}

	private static void print(int[][] pr) {
		for (int[] p : pr) {
			System.out.println(Arrays.toString(p));
		}
	}

	private static boolean safe(int nr, int nc) {

		return nr >= 0 && nc >= 0 && nr < H && nc < W;
	}

}
