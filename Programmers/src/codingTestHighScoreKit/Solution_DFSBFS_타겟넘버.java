package codingTestHighScoreKit;

public class Solution_DFSBFS_타겟넘버 {

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	static int[] number;
	static int targetNumber;
	static int answer;

	public static int solution(int[] numbers, int target) {
		number = numbers;
		targetNumber = target;
		answer = 0;
		int sum = 0;
		dfs(0, 0);

		return answer;
	}

	public static void dfs(int cnt, int sum) {
		if (cnt == number.length) {
			if (sum == targetNumber) {
				answer++;
			}
			return;
		}
		dfs(cnt + 1, sum + number[cnt]);
		dfs(cnt + 1, sum - number[cnt]);
	}
}
