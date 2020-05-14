package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1959_두개의숫자열 {
	static int T, N, M;
	static String[] arr;
	static String[] A_arr;
	static String[] B_arr;
	static int max;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= T; i++) {
			max = 0;
	
			String str = bf.readLine(); // 3 5
			arr = str.split(" ");

			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);
			String[] A_arr = new String[A];
			A_arr = bf.readLine().split(" ");
//			for (String s : A_arr) {
//				System.out.print(s+" ");
//				
//			}
//			System.out.println();
			String[] B_arr = new String[B];
			B_arr = bf.readLine().split(" ");
//			for (String s : B_arr) {
//				System.out.print(s+" ");
//				
//			}
//			System.out.println();
			if (A_arr.length <= B_arr.length) {
				
				for (int k = 0; k <= B_arr.length - A_arr.length; k++) {
					sum=0;
					for (int j = 0; j < A_arr.length; j++) {
						sum += Integer.parseInt(A_arr[j]) * Integer.parseInt(B_arr[j + k]);
					}
					if (max < sum) {
						max = sum;
					}
				}
			}
			else {
				for (int k = 0; k <= A_arr.length - B_arr.length; k++) {
					sum = 0;
					for (int j = 0; j < B_arr.length; j++) {
						sum += Integer.parseInt(A_arr[j + k]) * Integer.parseInt(B_arr[j]);
					}
					if (max < sum) {
						max = sum;
					}
				}
			}
			System.out.println("#" + i + " " + max);
		}
	}
}
