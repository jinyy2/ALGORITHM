package codingTestHighScoreKit;

public class Solution_동적계획법_등굣길 {

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 } };
		System.out.println(solution(m, n, puddles));
	}

	public static int solution(int m, int n, int[][] puddles) {
		int[][] map = new int[n][m];
		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
		}
		map[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == -1) {
					map[i][j] = 0;
					continue;
				}
				if (i != 0)
					map[i][j] += map[i - 1][j] % 1000000007;
				if (j != 0)
					map[i][j] += map[i][j - 1] % 1000000007;

			}
		}

		int answer = map[n - 1][m - 1];
		return answer % 1000000007;
	}

}
