package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_7964_부먹왕국의차원관문 {
	static int T, N, D;
	static String[] temp;
	static String[] arr;
	static String[] arr_door;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			count = 0;
			temp = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			D = Integer.parseInt(temp[1]);
			arr = new String[N + 2]; // 차원문 있음 양끝
			Arrays.fill(arr, "1"); // arr 111111111
			arr_door = br.readLine().split(" "); // arr_door의 길이는 arr-2
			for (int i = 1; i <= arr_door.length; i++) {
				arr[i] = arr_door[i - 1];
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals("1")) {
					loop: for (int j = 1; j <= D; j++) {

						if (i + j >= arr.length || arr[i + j].equals("1")) {
							break loop;
						} else if (arr[i + j].equals("0") && j == D) {
							count++;
							arr[i + j] = "1";
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}