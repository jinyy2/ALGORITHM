package level1;

public class L1_3진법뒤집기 {

	public static void main(String[] args) {
		int n = 45;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		String first = "";
		// 3진법으로 && 뒤집기
		while (n != 0) {
			first += n % 3;
			n /= 3;
		}

		// 10진법으로
		for (int i = first.length() - 1; i >= 0; i--) {
			answer += (first.charAt(first.length() - i - 1) - '0') * Math.pow(3, i);
		}
		return answer;
	}
}
