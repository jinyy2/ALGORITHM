package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_4676_늘어지는소리만들기 {
	static int T, H;
	static String[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = "";
			arr = br.readLine().split("");
			H = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());

				if (temp == 0) {
					str += "-";
				} else {
					arr[temp - 1] += "-";
				}
			}

			for (int i = 0; i < arr.length; i++) {
				str += arr[i];
			}

			System.out.println("#" + test_case + " " + str);
		}
	}
}
