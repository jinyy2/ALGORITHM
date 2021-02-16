package level2;

public class L2_124나라의숫자 {

	public static void main(String[] args) {
		int n = 7;
		System.out.println(solution(n));
	}

	public static String solution(int n) {
		String answer = "";
		String num = "";
		while (n > 0) {
			int value = n % 3;
			if (value == 0) {
				num = "4" + num;
				n--;
			} else if (value == 1) {
				num = "1" + num;
			} else if (value == 2) {
				num = "2" + num;
			}
			n /= 3;
		}

		answer = num;
		return answer;
	}
}
