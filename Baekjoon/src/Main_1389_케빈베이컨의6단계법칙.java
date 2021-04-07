import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {
	static int[][] friends;
	static boolean[] visited;
	static int[] count;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friends = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			friends[start][end] = 1;
			friends[end][start] = 1;
		}

		count = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				visited = new boolean[N + 1];
				if (i == j)
					continue;
				visited[i] = true;
				count[i] += bfs(i, j);

			}
		}
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (count[i] < min) {
				min = count[i];
				answer = i;
			}
		}
		System.out.println(answer);
	} // input-end

	private static int bfs(int start, int end) {
		// start : 시작
		// end : 찾을 숫자
		// k : 횟수
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (friends[start][i] == 1) {
				visited[i] = true;
				queue.offer(i);
			}
		}
		int cnt = 1;
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				int connect = queue.poll();
				if (connect == end)
					return cnt;

				for (int j = 1; j <= N; j++) {
					if (visited[j] || friends[connect][j] == 0)
						continue;
					visited[j] = true;
					queue.offer(j);

				}

			}
			++cnt;
		}
		return 0;
	}
}
