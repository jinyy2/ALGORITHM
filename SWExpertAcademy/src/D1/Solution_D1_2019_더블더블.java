package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2019_더블더블 {
	static int num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(bf.readLine());
		int n = 1;
		for (int i = 1; i <= num; i++) {
			System.out.print(n + " ");
			n *= 2;
		}
		System.out.print(n + " ");
	}
}
