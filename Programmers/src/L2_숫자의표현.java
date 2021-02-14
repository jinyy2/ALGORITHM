
public class L2_숫자의표현 {

	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 1;

		for (int i = 1; i <= n / 2; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += j;
				if (sum > n)
					break;
				else if (sum == n)
					answer++;
			}
		}

		return answer;
	}

}
