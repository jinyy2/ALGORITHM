package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_1936_1대1가위바위보 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String arr[] = str.split(" ");
		int A = Integer.parseInt(arr[0]);
		int B = Integer.parseInt(arr[1]);
		if (A == 1) {
			if (B == 2) {
				System.out.println("B");
			} else if (B == 3) {
				System.out.println("A");
			}
		} else if (A == 2) {
			if (B == 1) {
				System.out.println("A");
			} else if (B == 3) {
				System.out.println("B");
			}
		} else if (A == 3) {
			if (B == 1) {
				System.out.println("B");
			} else if (B == 2) {
				System.out.println("A");
			}
		}
	}
}
