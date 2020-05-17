package D3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Solution_D3_3131_100만이하의모든소수 {
	static boolean[] num;
//배수는true 
//소수는false

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		num = new boolean[1000001];
		StringBuilder sb = new StringBuilder();
		bw.write(2 + " ");
		for (int i = 3; i < Math.sqrt(num.length); i += 2) {
			if (!num[i]) {
				for (int j = 2; j < i / 2; j++) {
					if (i % j == 0) {
						num[i] = true;
						break;
					}
				}
				for (int j = i * 2; j < num.length; j += i) {
					num[j] = true;
				}
			}
		}
		for (int i = 3; i < num.length; i += 2) {
			if (!num[i])
				bw.write(i + " ");
		}
		bw.flush();
		bw.close();
	}
}
