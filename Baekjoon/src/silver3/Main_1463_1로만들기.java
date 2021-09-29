package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1463_1로만들기 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[10000001];
        int N = Integer.parseInt(br.readLine());
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp(N, 0);

        System.out.println(dp[1]);
    }

    public static void dp(int N, int cnt) {
        if (dp[N] > cnt)
            dp[N] = cnt;
        else return;
        if (N == 1) return;
        if (N % 3 == 0) dp(N / 3, cnt + 1);
        if (N % 2 == 0) dp(N / 2, cnt + 1);
        dp(--N, cnt + 1);
    }
}
