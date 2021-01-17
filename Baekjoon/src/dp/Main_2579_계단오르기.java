package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] dp = new int[301];
		int[] stair = new int[301];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = stair[1];
		dp[2] = Math.max(stair[2], stair[1] + stair[2]);
		for (int i = 3; i <= N; i++) {
			dp[i] += Math.max(stair[i] + dp[i - 2], stair[i] + stair[i - 1] + dp[i - 3]);
		}
		answer = dp[N];

		System.out.println(answer);
	}

}
