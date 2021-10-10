package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[3][n + 1];
            for (int i = 1; i <= n; i++) {
                dp[0][i] = stickers[0][i] + Math.max(dp[1][i - 1], dp[2][i - 1]);
                dp[1][i] = stickers[1][i] + Math.max(dp[0][i - 1], dp[2][i - 1]);
                dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                max = Math.max(max, dp[i][n]);
            }
            System.out.println(max);
        }
    }
}
