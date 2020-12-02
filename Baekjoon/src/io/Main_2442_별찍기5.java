package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2442_별찍기5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = N - i - 1; j > 0; j--) {
				sb.append(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

}
