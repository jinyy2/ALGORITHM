import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int flood;
	static int min;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		flood = 2;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		print(map);
		floodfill();
//		print(map);
		Queue<Point> q = new LinkedList<>();
		int cnt;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 || !edge(i, j))
					continue;
				visited = new boolean[N][N];
				cnt = 0;
				q.add(new Point(i, j));
				visited[i][j] = true;
				cnt++;
				loop: while (!q.isEmpty()) {
					Point temp;
					int qSize = q.size();
					for (int k = 0; k < qSize; k++) {
						temp = q.poll();
						for (int d = 0; d < 4; d++) {
							int nr = temp.r + dr[d];
							int nc = temp.c + dc[d];

							if (!safe(nr, nc) || visited[nr][nc] || map[i][j] == map[nr][nc])
								continue;

							// 종료 조건
							if (map[nr][nc] != map[i][j] && map[nr][nc] > 0) {
//								System.out.println(min +" "+ cnt);
								min = Math.min(min, cnt);
								q.clear();
								break loop;
							}

							visited[nr][nc] = true;
							q.offer(new Point(nr, nc));

						}
					}
					cnt++;
//					print(visited);
				}
			}
		}
		System.out.println(min - 1);
	}

	private static boolean edge(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if (!safe(nr, nc) || map[nr][nc] == 0)
				return true;
		}
		return false;
	}

	private static void floodfill() {
		Queue<Point> queue = new LinkedList<>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 1) {
					queue.add(new Point(i, j));
					map[i][j] = flood;
					while (!queue.isEmpty()) {
						Point temp = queue.poll();

						for (int d = 0; d < 4; d++) {
							int nr = temp.r + dr[d];
							int nc = temp.c + dc[d];

							if (!safe(nr, nc))
								continue;
							if (map[nr][nc] == 1) {
								map[nr][nc] = flood;
								queue.add(new Point(nr, nc));
							}
						}
					}
					flood++;
				}
			}
		}
	}

	private static boolean safe(int nr, int nc) {
		return 0 <= nr && 0 <= nc && nr < N && nc < N;
	}

	private static void print(boolean[][] visited2) {
		for (boolean[] p : visited2) {
			System.out.println(Arrays.toString(p));
		}
	}
}
