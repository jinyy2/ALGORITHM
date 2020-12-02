package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2445_별찍기8 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < 2 * N - 1; i++) {
			int blank = Math.abs(N - i - 1) * 2;
			int star = N - blank / 2;

			for (int j = 0; j < star; j++) {
				sb.append("*");
			}
			for (int j = 0; j < blank; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < star; j++) {
				sb.append("*");
			}

			sb.append("\n");

		}
		System.out.print(sb.toString());

	}

}
