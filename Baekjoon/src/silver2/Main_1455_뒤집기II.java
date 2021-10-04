package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1455_뒤집기II {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j] - '0';
            }
        }
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (map[i][j] == 1) {
                    cnt++;
                    for (int r = 0; r <= i; r++) {
                        for (int c = 0; c <= j; c++) {
                            if (map[r][c] == 1) map[r][c] = 0;
                            else map[r][c] = 1;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
