public class Solution_카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		int m = 13;
		int n = 16;
		int[][] picture = { { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, { 0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0 },
				{ 0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 } };

		System.out.println(solution(m, n, picture)[0] + " " + solution(m, n, picture)[1]);

	}
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int[][] map;
	static int count;
	static int M, N;
	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		visited = new boolean[m][n];
		map = picture;
		M = m;
		N = n;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					count = 1;
					numberOfArea++;
					visited[i][j] = true;
					dfs(i, j);
					maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);

				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	private static void dfs(int i, int j) {

		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if (!safe(nr, nc))
				continue;
			if (visited[nr][nc])
				continue;
			if (map[i][j] != map[nr][nc])
				continue;
			visited[nr][nc] = true;
			count++;
			dfs(nr, nc);

		}

	}

	private static boolean safe(int nr, int nc) {
		return 0 <= nr && 0 <= nc && nr < M && nc < N;
	}
}
