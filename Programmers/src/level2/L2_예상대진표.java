package level2;

public class L2_예상대진표 {

	public static void main(String[] args) {
		int n = 8;
		int a = 1;
		int b = 2;
		System.out.println(solution(n, a, b));
	}

	public static int solution(int n, int a, int b) {
		int answer = 0;
		if (b < a) {
			int temp = b;
			b = a;
			a = temp;
		}
		for (int i = 1; i <= 20; i++) {
			if ((int) Math.pow(2, i) == n) {
				answer = i;
				break;
			}
		}

		int sum = n / 2;
		n /= 2;
		while (true) {

			if (a <= sum && b > sum) {
				return answer;
			} else if (a <= sum && b <= sum) {
				sum -= n / 2;
			} else if (a > sum && b > sum) {
				sum += n / 2;
			}
			answer--;
			n /= 2;
		}

	}

}
