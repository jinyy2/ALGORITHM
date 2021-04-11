import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557_1학년 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long answer = 0;
		int[] num = new int[N]; // N개의 수
		long[][] dp = new long[21][N]; // 0-20 * N

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		dp[num[0]][0] = 1;
		for (int j = 1; j < N; j++) {
			for (int i = 0; i < dp.length; i++) {
				if (dp[i][j - 1] == 0)
					continue;
				int sum = i - num[j];
				if (0 <= sum) {
					dp[sum][j] += dp[i][j - 1];
				}
				sum = i + num[j];
				if (sum <= 20) {
					dp[sum][j] += dp[i][j - 1];
				}

			}
		}

		System.out.println(dp[num[N - 1]][N - 2]);
	}

}
