package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11720_숫자의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[] c = br.readLine().toCharArray();
		int sum = 0;
		for (int i = 0; i < c.length; i++) {
			sum += c[i] - '0';
		}

		System.out.print(sum);

	}

}
