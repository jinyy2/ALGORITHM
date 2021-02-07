package level2;

import java.util.Arrays;

public class L2_kakao2018_프랜즈4블록 {

	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };
		System.out.println(solution(m, n, board));
	}

	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] map = new char[m][];
		for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
		}
		boolean init = true;
		boolean[][] visited;

		while (init) {
			init = false;
			visited = new boolean[m][n];
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j] != '*' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j]
							&& map[i][j] == map[i + 1][j + 1]) {
						init = true; // 초기화
						visited[i][j] = true;
						visited[i + 1][j] = true;
						visited[i][j + 1] = true;
						visited[i + 1][j + 1] = true;
					}
				} // for-end
			} // for-end

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j]) {
						answer++;
						map[i][j] = '*';
					}

				} // for-end
			} // for-end

			// 블록내리기
			for (int i = m - 1; i > 0; i--) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '*') {
						int k = i - 1;
						while (k >= 0) {
							if (map[k][j] != '*') {
								int temp = map[i][j];
								map[i][j] = map[k][j];
								map[k][j] = '*';
								break;
							}
							k--;
						}
					}
				}
			}
		}

		return answer;
	}

}
