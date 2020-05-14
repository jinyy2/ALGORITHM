package D2;

import java.util.Scanner;

public class Solution_D2_1945_간단한소인수분해 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();

		for (int i = 1; i <= cnt; i++) {
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			int n = sc.nextInt();

			while (n % 2 == 0) {
				a++;
				n /= 2;
			}
			while (n % 3 == 0) {
				b++;
				n /= 3;
			}
			while (n % 5 == 0) {
				c++;
				n /= 5;
			}
			while (n % 7 == 0) {
				d++;
				n /= 7;
			}
			while (n % 11 == 0) {
				e++;
				n /= 11;
			}

			System.out.println("#" + i + " " + a + " " + b + " " + c + " " + d + " " + e);
		}

	}

}
