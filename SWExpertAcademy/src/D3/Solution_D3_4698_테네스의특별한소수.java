package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_4698_테네스의특별한소수 {
	static int T, D, A, B;
	static int count;
	static boolean[] num = new boolean[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		num[0] = true;
		num[1] = true;
		int idx;

		for (int i = 2; i <= Math.sqrt(num.length); i++) {
			if (!num[i]) {
				idx = 2 * i;
				while (idx < num.length) {
					num[idx] = true;
					idx += i;
				}
			}
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			count = 0;

			for (int i = A; i <= B; i++) {
				if (!num[i] && isContain(i)) {
//				if (!num[i] && ("" + i).contains("" + D)) {
					count++;
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}

	public static boolean isContain(int n) {
		int tmp;
		while (n > 0) {
			tmp = n % 10;
			if (tmp == D)
				return true;
			n /= 10;
		}
		return false;
	}
}
