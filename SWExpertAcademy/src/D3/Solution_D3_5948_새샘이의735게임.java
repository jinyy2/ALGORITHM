package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Solution_D3_5948_새샘이의735게임 {
	static int T;
	static String[] number;
	static int sum;
	static int[] num;
	private static HashSet<Integer> hs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		hs = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			number = br.readLine().split(" ");
			num = new int[3];
			hs = new HashSet<>();
			hs.clear();
			select(number.length, 3, 0, 0);
			ArrayList<Integer> sumArr = new ArrayList<Integer>(hs);
			Collections.sort(sumArr, Collections.reverseOrder());
			int max5 = sumArr.get(4);
			bw.write("#" + test_case + " " + max5+"\n");
		}
		bw.close();
	}

	public static void select(int n, int r, int start, int count) {
		if (count == r) {
			hs.add(sum);
			return;
		}
		for (int i = start; i < number.length; i++) {
			num[count] = Integer.parseInt(number[i]);
			sum += num[count];
			select(number.length, 3, i + 1, count + 1);
			sum -= num[count];
		}
	}
}
