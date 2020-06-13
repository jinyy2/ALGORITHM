package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_1868_파핑파핑지뢰찾기 {
	static int T, N;
	static char[][] map;
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			count = 0;

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '.' && safeBomb(i, j)) {
						count++;
						goDfs(i, j);
					}
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '.') {
						count++;
					}
				}
			}
			System.out.println("#" + test_case + " " + count);

		}

	}

	private static boolean safeBomb(int i, int j) {
		for (int d = 0; d < 8; d++) {
			int tempY = i + dy[d];
			int tempX = j + dx[d];
			if (safe(tempY, tempX) && map[tempY][tempX] == '*') {
				return false;
			}
		}
		return true;
	}

	private static void goDfs(int i, int j) {
		int bomb = 48;
		for (int d = 0; d < 8; d++) {
			int countY = i + dy[d];
			int countX = j + dx[d];
			if (safe(countY, countX) && map[countY][countX] == '*') {
				bomb++;
			}
		}
		if (bomb != 48) {
			map[i][j] = (char) bomb;
		} else if (bomb == 48) {
			map[i][j] = '0';
			for (int d = 0; d < 8; d++) {
				int tempY = i + dy[d];
				int tempX = j + dx[d];
				if (safe(tempY, tempX) && map[tempY][tempX] == '.') {
					goDfs(tempY, tempX);
				}
			}
		}
	}

	private static boolean safe(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N) {
			return true;
		} else {
			return false;
		}
	}

	private static void print(char[][] pr) {
		for (int i = 0; i < pr.length; i++) {
			for (int j = 0; j < pr.length; j++) {
				System.out.print(pr[i][j]);
			}
			System.out.println();
		}
	}

}
