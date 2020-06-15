package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울 {
	static int T;
	static int result;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			int[] w = new int[N];
			boolean[] visited = new boolean[N];
			result = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				w[i] = Integer.parseInt(st.nextToken());
			}
			combi(0, 0, 0, w, visited);
			System.out.println("#" + test_case + " " + result);
		}

	}

	private static void combi(int i, int left, int right, int[] w, boolean[] visited) {
		if (left < right)
			return;

		if (N == i) {
			result++;
			return;
		}
		for (int j = 0; j < w.length; j++) {
			if (visited[j])
				continue;
			visited[j] = true;
			combi(i + 1, left + w[j], right, w, visited);
			combi(i + 1, left, right + w[j], w, visited);
			visited[j] = false;

		}
	}
}
