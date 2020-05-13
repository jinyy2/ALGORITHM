package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2050_알파벳을숫자로변환 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String[] arr = str.split("");
		char[] arr2 = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.print((int) arr2[i] - 64 + " ");
		}
	}
}
