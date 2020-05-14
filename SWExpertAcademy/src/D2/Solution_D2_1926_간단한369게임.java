package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1926_간단한369게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			int temp = i;
			boolean check = true;
			
			while (temp > 0) {
				if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9) {
					check = false;
					System.out.print("-");
				}
				temp /= 10;
			}
			
			if (check) {
				System.out.print(i + " ");
			} else {
				System.out.print(" ");
			}
		}
	}
}
