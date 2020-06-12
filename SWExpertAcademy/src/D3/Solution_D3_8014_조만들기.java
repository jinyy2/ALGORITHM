package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_8014_조만들기 {
	static int T, N, K;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][K];
			int num = 1;
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < K; j++) {
						arr[i][j] = num;
						num++;
					}
				} else {
					for (int j = K - 1; j >= 0; j--) {
						arr[i][j] = num;
						num++;
					}
				}
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < K; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += arr[j][i];
				}
				System.out.print(sum + " ");
			}
			System.out.println();
		}
	}
}