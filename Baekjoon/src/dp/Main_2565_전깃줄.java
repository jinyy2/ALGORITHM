package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2565_전깃줄 {
	static class Point {
		int left;
		int right;

		public Point(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		Point[] wire = new Point[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			wire[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(wire, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return p1.left - p2.left;
			}
		});
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (wire[i].right > wire[j].right) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i : dp) {
			max = Math.max(max, i);
		}
		System.out.println(N - (max + 1));

	}

}
