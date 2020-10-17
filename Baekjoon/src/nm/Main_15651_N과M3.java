package nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651_N과M3 {
	static int N, M;
	static int[] seq;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		seq = new int[M];

		permuRepu(0);
		System.out.println(sb);
	}

	private static void permuRepu(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < seq.length; i++) {
				sb.append(seq[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			seq[cnt] = i + 1;
			permuRepu(cnt + 1);
		}
	}
}
