package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_4751_다솔이의다이아몬드장식 {
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			if (str.length() == 1) {
				System.out.println("..#..\n.#.#.\n#." + str + ".#\n.#.#.\n..#..");
			} else {
				System.out.print("..");
				for (int i = 0; i < str.length() - 1; i++) {
					System.out.print("#...");
				}
				System.out.print("#..\n.");
				for (int i = 0; i < str.length() * 2; i++) {
					System.out.print("#.");
				}
				System.out.println();
				System.out.print("#");
				for (int i = 0; i < str.length(); i++) {
					System.out.print("." + str.charAt(i) + ".#");
				}
				System.out.print("\n.");
				for (int i = 0; i < str.length() * 2; i++) {
					System.out.print("#.");
				}
				System.out.print("\n..");
				for (int i = 0; i < str.length() - 1; i++) {
					System.out.print("#...");
				}
				System.out.println("#..");
			}
		}
	}

}
