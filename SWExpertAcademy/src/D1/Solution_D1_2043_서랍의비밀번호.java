package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2043_서랍의비밀번호 {
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String[] arr = str.split(" ");
		int P = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);

		for (int i = K; i <= P; i++) {
			count++;
		}
		System.out.println(count);
	}
}
