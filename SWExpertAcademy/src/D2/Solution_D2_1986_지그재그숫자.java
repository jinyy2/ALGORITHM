package D2;

import java.util.Scanner;

public class Solution_D2_1986_지그재그숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			int sum = 0;
			arr[i] = sc.nextInt();
			for (int j = 1; j <= arr[i]; j++) {
				if (j % 2 == 1) {
					sum += j;
				} else {
					sum -= j;
				}
			}
			System.out.println("#" + (i + 1) + " " + sum);
		}

	}
}
