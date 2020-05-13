package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D1_2063_중간값찾기 {
	static int T;
	static int[] arr2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		String str = bf.readLine();
		String[] arr = str.split(" ");
		arr2 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(arr2);
		System.out.println(arr2[arr.length / 2]);
	}
}
