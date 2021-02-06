package level2;

public class L2_kakao2018_소수만들기 {

	public static void main(String[] args) {
		int[] nums = {1,2,7,6,4};
		System.out.println(solution(nums));
	}

	static int[] numbers;
	static int answer;

	public static int solution(int[] nums) {
		answer = 0;
		numbers = nums;
		combi(0, 0, 0);

		return answer;
	}

	public static void combi(int cnt, int cur, int sum) {
		if (cnt == 3) {
			if (sum % 2 == 0)
				return;
			boolean flag = true;
			for (int i = 2; i <= (int) Math.sqrt(sum); i++) {
				if (sum % i == 0) {
					flag = false;
					return;
				}
			}
			if (flag)
				answer++;
			return;
		}
		for (int i = cur; i < numbers.length; i++) {

			combi(cnt + 1, i + 1, sum + numbers[i]);

		}
	}

}
