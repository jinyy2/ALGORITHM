package level1;

public class L1_2016년 {
	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		System.out.println(solution(a, b));
	}

	public static String solution(int a, int b) {
		String answer = "";
		String[] week = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED", };
		int[] month = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		while (a > 1) {
			b += month[--a];
		}
		answer = week[b % 7];

		return answer;
	}
}
