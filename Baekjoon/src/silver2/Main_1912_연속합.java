package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[N + 1];
        dp[0]=num[0];
        Arrays.fill(dp, -100000001);
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);

    }
}
