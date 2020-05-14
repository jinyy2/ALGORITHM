package D2;

import java.util.Scanner;

public class Solution_D2_1288_새로운불면증치료법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		// 0-9 false

		for (int i = 1; i <= cnt; i++) {
			int num = sc.nextInt();
			boolean[] bl = new boolean[10];
			int num_count = 1;
			while (true) {
				int num2 = num * num_count;
				while (num2 > 0) {
					bl[num2 % 10] = true;
					num2 /= 10;
				}

				int bl_cnt = 0;
				for (int k = 0; k < bl.length; k++) {
					if (bl[k] == true) {
						bl_cnt++;
					}
				}
				if (bl_cnt == 10) {
					System.out.println("#" + i + " " + num_count * num);
					break;
				} else {
					num_count++;
				}
			}
		}
	}
}
