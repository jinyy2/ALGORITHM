import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		result = Integer.MIN_VALUE;

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input-end
//		print(map);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
			}
		}
		nhjk();
		System.out.println(result);
	}

	private static void dfs(int i, int j, int depth, int sum) {
		if (depth == 4) {
			result = Math.max(result, sum);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if (!safe(nr, nc))
				continue; // 2차원 배열 밖을 나가는지 확인
			if (visited[nr][nc])
				continue; // 방문했으면 패스
			visited[nr][nc] = true;
			dfs(nr, nc, depth + 1, sum + map[nr][nc]);
			visited[nr][nc] = false;

		}

	}
	//ㅜ ㅗ ㅓ ㅏ
	private static void nhjk() {
		// ㅜ
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 2; j++) {
				int temp = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1];
				result = Math.max(result, temp);
			}
		}
		// ㅗ
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M - 2; j++) {
				int temp = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i - 1][j + 1];
				result = Math.max(result, temp);
			}
		}

		// ㅓ
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < M; j++) {
				int temp = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j - 1];
				result = Math.max(result, temp);
			}
		}
		// ㅏ
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 1; j++) {
				int temp = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1];
				result = Math.max(result, temp);
			}
		}

	}

	private static boolean safe(int nr, int nc) {
		return 0 <= nr && 0 <= nc && nr < N && nc < M;
	}

	private static void print(int[][] pr) {
		for (int[] p : pr) {
			System.out.println(Arrays.toString(p));
		}
	}

}
