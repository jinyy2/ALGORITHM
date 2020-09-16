import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {
	static char[][] map;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int temp = check(i, j, map[i][j]);
				result = Math.min(result, temp);
			}
		}
		System.out.println(result);
	}

	private static int check(int i, int j, char ch) {
		int min = 0;
		for (int r = i; r < i + 8; r++) {
			if (r % 2 == 0) {
				for (int c = j; c < j + 8; c++) {
					if (c % 2 == 0) {
						if (map[r][c] != ch)
							min++;

					} else if (c % 2 == 1) {
						if (map[r][c] == ch)
							min++;
					}
				}
			} else if (r % 2 == 1) {
				for (int c = j; c < j + 8; c++) {
					if (c % 2 == 0) {
						if (map[r][c] == ch)
							min++;
					} else if (c % 2 == 1) {
						if (map[r][c] != ch)
							min++;
					}
				}
			}
		}
		if (min > 32)
			min = 64 - min;
		return min;
	}

}
