package nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_N과M1 {

	static int N, M;
	static int[] seq;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		seq = new int[M];
		visited = new boolean[N];
		permutation(0);

	}

	private static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < seq.length; i++) {
				System.out.print(seq[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			seq[cnt] = i + 1;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}

}
