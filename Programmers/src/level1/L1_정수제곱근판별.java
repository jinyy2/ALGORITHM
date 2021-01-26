package level1;

public class L1_정수제곱근판별 {

	public static void main(String[] args) {
		long n = 121;
		System.out.println(solution(n));
	}

	public static long solution(long n) {
		long answer = 0;
		int i = (int) Math.sqrt(n);
		if (Math.sqrt(n) == (double) i) {
			answer = (long) (i + 1) * (long) (i + 1);
		} else {
			answer = -1;
		}
		return answer;
	}

}
