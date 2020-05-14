package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1970_쉬운거스름돈 {
	static int T;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			int money = Integer.parseInt(bf.readLine());
			arr = new int[8];
			if (money >= 50000) {
				arr[0] += money / 50000;
				money = money % 50000;
			}
			if (money >= 10000) {
				arr[1] += money / 10000;
				money = money % 10000;
			}
			if (money >= 5000) {
				arr[2] += money / 5000;
				money = money % 5000;
			}
			if (money >= 1000) {
				arr[3] += money / 1000;
				money = money % 1000;
			}
			if (money >= 500) {
				arr[4] += money / 500;
				money = money % 500;
			}
			if (money >= 100) {
				arr[5] += money / 100;
				money = money % 100;
			}
			if (money >= 50) {
				arr[6] += money / 50;
				money = money % 50;
			}
			if (money >= 10) {
				arr[7] += money / 10;
				money = money % 10;
			}
			System.out.println("#" + (i + 1));
			for (int k : arr) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}
