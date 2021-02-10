package level2;

public class L2_피보나치수 {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		int[] fibo = new int[n + 1];
		fibo[1] = 1;
		for (int i = 2; i < fibo.length; i++) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
		}
		answer = fibo[n];
		return answer;
	}

}
