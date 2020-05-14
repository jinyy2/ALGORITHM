import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_안전지역 {

	static int N;
	static int map[][];
	static boolean[][] safeArea;
	static int maxHeight;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		maxHeight = Integer.MIN_VALUE;
		max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		// input-end
//		print(map); // check-input

		//
		for (int i = 1; i <= maxHeight; i++) {
			safeArea = new boolean[N][N];
			int cnt = 0;

			// 물의 높이 i미만 물에 잠김
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] < i) {
						safeArea[y][x] = true;
					}
				}
			}

			// 안전한 영역 개수 구하기
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (!safeArea[y][x]) {
						cnt++;
						dfs(y, x);
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

	private static void dfs(int y, int x) {
		safeArea[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (safe(ny, nx) && !safeArea[ny][nx]) {
				dfs(ny, nx);
			}
		}
	}

	// 배열 밖으로 나가지 않도록 하는 method
	private static boolean safe(int ny, int nx) {
		return ny >= 0 && ny < N && nx >= 0 && nx < N;
	}

	// input chceck method
	private static void print(int[][] pr) {
		for (int i = 0; i < pr.length; i++) {
			for (int j = 0; j < pr[i].length; j++) {
				System.out.print(pr[i][j] + " ");
			}
			System.out.println();
		}
	}
}