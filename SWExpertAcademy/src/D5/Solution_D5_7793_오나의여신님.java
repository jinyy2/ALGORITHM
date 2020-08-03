package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D5_7793_오나의여신님 {

	static int result;
	static int N, M;
	static char[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Point start, end, virus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			result = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			int sec = 0;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			} // input-end
//			print(map);
			Queue<Point> queue = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'S') {
						start = new Point(i, j, 'S'); // 수연
					} else if (map[i][j] == '*') {
						virus = new Point(i, j, '*');
						queue.add(virus); // 바이러스
					}
				}
			}
			queue.add(start); // 수연
			label: while (!queue.isEmpty()) {
				sec += 1;
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Point temp = queue.poll();

					if (temp.ch == '*') { // 바이러스 퍼짐
						for (int d = 0; d < 4; d++) {
							int nr = temp.r + dr[d];
							int nc = temp.c + dc[d];

							if (safe(nr, nc) && (map[nr][nc] == '.' || map[nr][nc] == 'S')) {
								map[nr][nc] = '*';
								queue.add(new Point(nr, nc, '*'));
							}
						}
					} else if (temp.ch == 'S') {
						for (int d = 0; d < 4; d++) {
							int nr = temp.r + dr[d];
							int nc = temp.c + dc[d];

							if (safe(nr, nc) && map[nr][nc] == '.') {
								map[nr][nc] = 'S';
								queue.add(new Point(nr, nc, 'S'));
							} else if (safe(nr, nc) && map[nr][nc] == 'D') {
								result = sec;
								break label;
							}
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + (result == -1 ? "GAME OVER" : result));
		}

	}

	private static boolean safe(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

	private static void print(char[][] pr) {
		for (char[] p : pr) {
			for (char a : p) {
				System.out.print(a);
			}
			System.out.println();
		}
	}
}

class Point {
	int r;
	int c;
	char ch;

	public Point(int r, int c, char ch) {
		this.r = r;
		this.c = c;
		this.ch = ch;
	}

	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + ", ch=" + ch + "]";
	}

}
