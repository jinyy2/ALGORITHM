package D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_5356_의석이의세로로말해요 {
	static int T,N,K;
	static char[][] word;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			N = 15;
			K = 5;
			word = new char[K][N];
			for (int i = 0; i < K; i++) {
				Arrays.fill((word[i]), ' ');
			}
			for (int i = 0; i < K; i++) {
				String ns = sc.next();
				System.arraycopy(ns.toCharArray(), 0, word[i], 0, ns.length());
			}
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < K; j++) {
					if(word[j][i] != ' ') {
						sb.append(word[j][i]);
					}
				}
				
			}
			System.out.println("#"+iT+" "+sb.toString());
		}
	}
}