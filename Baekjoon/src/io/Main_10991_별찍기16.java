package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10991_별찍기16 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			for (int j = N - i; j > 0; j--) {
				sb.append(" ");
			}
			for (int j = 0; j < i; j++) {
				sb.append("*").append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

}
