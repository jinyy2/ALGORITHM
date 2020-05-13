package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_1545_거꾸로출력해보아요 {
	static int num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(bf.readLine());
		for (int i = num; i >= 0; i--) {
			System.out.print(i + " ");
		}
	}
}
