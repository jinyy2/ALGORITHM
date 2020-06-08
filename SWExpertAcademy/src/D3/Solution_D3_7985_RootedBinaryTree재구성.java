package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7985_RootedBinaryTree재구성 {
	static int T, K;
	static int[] arr;
	static int m;
	static int newStart;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[(int) Math.pow(2, K)];
			for (int i = 1; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			System.out.print("#" + test_case + " ");
			for (int i = K; i > 0; i--) {
				int start = (int) Math.pow(2, i - 1);
				for (int j = start; j < arr.length; j += start * 2) {
					System.out.print(arr[j] + " ");

				}
				System.out.println();
			}
		}
	}

	public static void print(int[] prArr) {
		for (int pr = 1; pr < prArr.length; pr++) {
			System.out.print(prArr[pr]);
		}
		System.out.println();
	}
}
