package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1912_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MIN_VALUE);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = num[0];
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i-1]+num[i], num[i]);
			
		}
		int max = Integer.MIN_VALUE;
		for (int d : dp) {
			max = Math.max(max, d);
		}
		System.out.println(max);

	}

}
