package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2025_N줄덧셈 {
	static int N;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= N; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
