package level1;

public class L1_두정수사이의합 {

	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		System.out.println(solution(a, b));
	}

	public static long solution(int a, int b) {
		long answer = 0;
		if (a == b)
			return a;
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}

		while (a != b) {
			answer += b--;
		}

		return answer + a;

	}

}
