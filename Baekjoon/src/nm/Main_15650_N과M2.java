package nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N과M2 {
	static int N, M;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		seq = new int[M];
		combi(0, 0);

	}

	private static void combi(int cnt, int cur) {
		if (cnt == M) {
			for (int i = 0; i < seq.length; i++) {
				System.out.print(seq[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = cur; i < N; i++) {
			seq[cnt] = i + 1;
			combi(cnt + 1, i + 1);
		}
	}
}
