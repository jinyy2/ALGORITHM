package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10818_최소최대 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) { // 1492ms
//			num[i] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(num);
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while (st.hasMoreTokens()) { // 632ms
			int val = Integer.parseInt(st.nextToken());

			if (val < min)
				min = val;
			if (val > max)
				max = val;
		}
//		System.out.print(num[0] + " " + num[N - 1]);
		System.out.print(min + " " + max);
	}

}
