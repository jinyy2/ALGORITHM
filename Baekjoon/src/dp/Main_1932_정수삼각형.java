package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine().trim());
		int[][] triangle = new int[5][];

		for (int i = 0; i < N; i++) {
			triangle[i] = new int[i + 1];
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < triangle[i].length; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N; i++) {
			triangle[i][0] += triangle[i - 1][0];
			triangle[i][i] += triangle[i - 1][i - 1];
			for (int j = 1; j < i; j++) {
				triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < triangle.length; i++) {
			System.out.println(triangle[triangle.length - 1][i]);
			max = Math.max(max, triangle[triangle.length - 1][i]);
		}
		System.out.println(max);
	}

}
