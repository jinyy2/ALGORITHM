package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11721_열개씩끊어출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] c = br.readLine().toCharArray();
		int cnt = 0;
		for (int i = 0; i < c.length; i++) {
			sb.append(c[i]);
			if (i % 10 == 9) {
				sb.append("\n");
			}
		} // 136ms
		
//		while (c.length != cnt) {
//			sb.append(c[cnt++]);
//			if (cnt % 10 == 0)
//				sb.append("\n");
//		} // 212ms

		System.out.print(sb.toString());

	}

}
