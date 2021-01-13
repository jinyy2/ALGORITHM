package codingTestHighScoreKit;

public class Solution_DFSBFS_네트워크 {

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(solution(n, computers));
	}

	static int[][] map;
	static boolean[] visited;

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		map = computers;
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			answer++;
			dfs(i, n);
		}

		return answer;
	}

	private static void dfs(int c, int n) {
		for (int i = 0; i < n; i++) {
			if (i != c && map[c][i] == 1) {
				if (visited[i])
					continue;
				visited[i] = true;
				dfs(i, n);
			}

		}
	}
}
