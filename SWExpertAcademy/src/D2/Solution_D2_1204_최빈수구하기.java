package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1204_최빈수구하기 {
	static int T;
	static int n;
	static String[] arr;
	static int[] num;
	static int fre;
	static int index;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= T; i++) {
			n = Integer.parseInt(bf.readLine());
			String str = bf.readLine();
			arr = str.split(" ");
			num = new int[101];
			for (int j = 0; j < arr.length; j++) {
				num[Integer.parseInt(arr[j])]++;
			}
			fre = 0;
			for (int j = 0; j < num.length; j++) {
				if (fre <= num[j]) {
					fre = num[j];
					index = j;
				}
			}
			System.out.println("#" + i + " " + index);
		}
	}
}