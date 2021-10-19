package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13398_연속합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        dp1[0] = num[0];
        dp2[N - 1] = num[N - 1];
        int max = dp1[0];

        for (int i = 1; i < N; i++) {
            dp1[i] = Math.max(dp1[i - 1] + num[i], num[i]);
            max = Math.max(max, dp1[i]);
        }
        for (int i = N - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1] + num[i], num[i]);
            max = Math.max(max, dp2[i]);
        }

        for (int i = 1; i < N - 1; i++) {
            max = Math.max(max, dp1[i - 1] + dp2[i + 1]);
        }
        System.out.println(max);
    }
}
