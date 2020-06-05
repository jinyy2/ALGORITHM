package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_D3_8888_시험 {
    static int Tc, N, T, P;
    static int rank;
    static int[][] arr;
    static int[] cnt;
    static int[] sum;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tc = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= Tc; test_case++) {
            rank = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            arr = new int[N + 1][T];
            sum = new int[N];
            cnt = new int[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < T; j++) {
                    arr[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            for (int i = 0; i < T; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[j][i] == 0) {
                        arr[N][i]++;
                    } else {
                        cnt[j]++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    if (arr[i][j] == 1) {
                        sum[i] += arr[N][j];
                    } else {
                        continue;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (i != P - 1) {
                    if (sum[i] > sum[P - 1]) {
                        rank++;
                    } else if (sum[i] == sum[P - 1]) {
                        if (cnt[i] > cnt[P - 1]) {
                            rank++;
                        } else if (cnt[i] == cnt[P - 1]) {
                            if (i < P - 1) {
                                rank++;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + sum[P - 1] + " " + rank);
        }
    }
 
}
