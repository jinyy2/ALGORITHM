package weeklyChallenge;

public class Solution_부족한금액계산하기 {

	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}

	public static long solution(int price, int money, int count) {
		long answer = (long) price * count * (1 + count) / 2;
		return answer <= money ? 0 : Math.abs(answer - money);
	}

}
