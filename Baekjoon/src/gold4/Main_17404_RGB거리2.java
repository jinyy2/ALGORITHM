package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17404_RGB거리2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][] dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//input-end
        int min = Integer.MAX_VALUE;
        for (int f = 0; f < 3; f++) {
            for (int i = 0; i < 3; i++) {
                if (f == i) dp[0][i] = map[0][i];
                else dp[0][i] = 1000*N+1;
            }
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2])+map[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2])+map[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1])+map[i][2];
            }
            for (int i = 0; i < 3; i++) {
                if(i==f)continue;
                 min = Math.min(min,dp[N-1][i]);
            }
        }
        System.out.println(min);

}
}
