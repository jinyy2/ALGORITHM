import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2458_키순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		int[][] map = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			map[start][end] = 1;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					if (map[i][k] == 1 & map[k][j] == 1)
						map[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (map[i][j] == 1 || map[j][i] == 1)
					cnt++;
			}
			if (cnt == N - 1)
				answer++;
		}
		System.out.println(answer);
	}

}
