package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1309_동물원 {
    static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        long[][] dp = new long[N][3];
//        //0 : left, 1 : right, 2 : zero
//        dp[0][0] = dp[0][1] = dp[0][2] = 1;
//
//        for (int i = 1; i < N; i++) {
//            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % MOD;
//            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
//            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
//        }
//        long answer = (dp[N-1][0] + dp[N-1][1] + dp[N-1][2]) % MOD;
//        System.out.println(answer);

        // 점화식
        int[] dp = new int[100001];
        dp[1] = 3;
        dp[2] = 7;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % MOD;
        }
        System.out.println(dp[N]);
    }
}
