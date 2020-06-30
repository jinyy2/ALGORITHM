package SW;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_1226_미로1 {
	static int N = 16;
	static int T;
	static char[][] map;
	static int cnt;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new char[N][N];
		for (int test_case = 1; test_case <= 10; test_case++) {
			T = Integer.parseInt(br.readLine());
			result = 0;
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '2') {
						go(i, j, 2);
					}
				}
			}
			System.out.println("#" + test_case + " " + result);
//				print(map);
		}
	}

	private static void print(char[][] pr) {
		for (int i = 0; i < pr.length; i++) {
			for (int j = 0; j < pr.length; j++) {
				System.out.print(pr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void go(int y, int x, int c) {
		if (map[y][x] == '3') {
			result = 1;
			return;
		} else {
			map[y][x] = '2';
		}
		for (int d = 0; d < 4; d++) {
			if (safe(y + dy[d], x + dx[d]) && (map[y + dy[d]][x + dx[d]] == '0') || map[y + dy[d]][x + dx[d]] == '3') {
				go(y + dy[d], x + dx[d], c);

			}
		}
	}

	public static boolean safe(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N) {
			return true;
		} else {
			return false;
		}
	}
}
