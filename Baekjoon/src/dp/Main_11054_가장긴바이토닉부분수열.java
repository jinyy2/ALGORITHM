package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11054_가장긴바이토닉부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		int[] dp2 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		for (int i = N - 1; i > 0; i--) {
			for (int j = N - 1; j > i; j--) {
				if (arr[j] < arr[i])
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i] + dp2[i]);
		}

		System.out.println(answer + 1);

	}

}
