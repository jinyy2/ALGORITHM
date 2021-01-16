package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < N; i++) {
			map[i][0] += Math.min(map[i - 1][1], map[i - 1][2]);
			map[i][1] += Math.min(map[i - 1][0], map[i - 1][2]);
			map[i][2] += Math.min(map[i - 1][0], map[i - 1][1]);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, map[N - 1][i]);
		}
		System.out.println(min);
	}

}
