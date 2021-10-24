package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1058_친구 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
			map[i][i] = 0;
		}

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == 'Y')
					map[i][j] = 1;
			}
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					if (map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE)
						continue;
					map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
				}
			}
		}
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < map.length; i++) {
			int cnt = 0;
			for (int j = 0; j < map.length; j++) {
				if (0 < map[i][j] && map[i][j] <= 2)
					++cnt;
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}

}
