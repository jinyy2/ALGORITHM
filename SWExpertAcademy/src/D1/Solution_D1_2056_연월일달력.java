package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2056_연월일달력 {
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= T; i++) {
			String str = bf.readLine();
			checkVaild(i, str);
		}
	}

	public static void checkVaild(int i, String str) {

		String yy = (str.substring(0, 4));
		String mm = (str.substring(4, 6));
		String dd = (str.substring(6, 8));

		int year = Integer.parseInt(yy);
		int month = Integer.parseInt(mm);
		int day = Integer.parseInt(dd);

		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day > 0 && day <= 31) {
				print(i, yy, mm, dd);
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day > 0 && day <= 30) {
				print(i, yy, mm, dd);
			}
		} else if (month == 2 && day > 0 && day <= 28) {
			print(i, yy, mm, dd);
		} else {
			System.out.println("#" + i + " -1");
		}
	}

	public static void print(int i, String year, String month, String day) {
		System.out.println("#" + i + " " + year + "/" + month + "/" + day);
	}
}
