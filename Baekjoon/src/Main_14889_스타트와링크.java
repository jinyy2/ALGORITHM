import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {

	static int N;
	static int[][] map;
	static int[] start;
	static int[] link;
	static int[] score_s;
	static int[] score_l;
	static boolean[] visited;
	static int min;
	static int sum_s;
	static int sum_l;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		start = new int[N / 2];
		link = new int[N / 2];
		visited = new boolean[N];
		score_s = new int[2];
		score_l = new int[2];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input-end
//		print(map);
		combi(0, 0);
		System.out.println(min);

	}

	private static void combi(int cnt, int cur) {
		if (cnt == N / 2) {
			int temp = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					link[temp++] = i;
				}
			}
			sum_s = 0;
			sum_l = 0;
			permu(0, 0);
			min = Math.min(min, Math.abs(sum_s - sum_l));
//			System.out.println("start: "+Arrays.toString(start));
//			System.out.println("link: "+Arrays.toString(link));

			return;
		}

		for (int i = cur; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				start[cnt] = i;
				combi(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	private static void permu(int cnt, int cur) {
		if (cnt == 2) {
//			System.out.println("score: "+Arrays.toString(score));
			sum_s += map[score_s[0]][score_s[1]] + map[score_s[1]][score_s[0]];
			sum_l += map[score_l[0]][score_l[1]] + map[score_l[1]][score_l[0]];
			return;
		}
		for (int i = cur; i < N / 2; i++) {
			score_s[cnt] = start[i];
			score_l[cnt] = link[i];
			permu(cnt + 1, i + 1);

		}
	}

	private static void print(int[][] pr) {
		for (int[] p : pr) {
			System.out.println(Arrays.toString(p));
		}
	}
}
