package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SW_1249_보급로 {
	static int T, N;
	static int[][] map;
	static int[][] minMap;
	static int sy, sx, ey, ex;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			minMap = new int[N][N];
			sy = 0;
			sx = 0;
			ey = N - 1;
			ex = N - 1;

			for (int i = 0; i < map.length; i++) {
				String str = br.readLine();
				for (int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			for (int i = 0; i < minMap.length; i++) {
				for (int j = 0; j < minMap[i].length; j++) {
					minMap[i][j] = Integer.MAX_VALUE;
				}
			}
			minMap[0][0] = 0;
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[] { sy, sx });

			while (!queue.isEmpty()) {
				int temp[] = queue.poll();
				for (int d = 0; d < 4; d++) {
					int tempY = temp[0] + dy[d];
					int tempX = temp[1] + dx[d];

					if (safe(tempY, tempX) && minMap[tempY][tempX] > minMap[temp[0]][temp[1]] + map[tempY][tempX]) {
						minMap[tempY][tempX] = minMap[temp[0]][temp[1]] + map[tempY][tempX];
						queue.offer(new int[] { tempY, tempX });
					}
				}
			}
			System.out.println("#" + test_case + " " + minMap[ey][ex]);
		}
	}

	private static boolean safe(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N) {
			return true;
		} else {
			return false;
		}
	}

	private static void print(int[][] pr) {
		for (int i = 0; i < pr.length; i++) {
			for (int j = 0; j < pr[i].length; j++) {
				System.out.print(pr[i][j]);
			}
			System.out.println();
		}
	}
}