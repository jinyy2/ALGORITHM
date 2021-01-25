package level1;

public class L1_x만큼간격이있는n개의숫자 {

	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		System.out.println(solution(x, n));
	}

	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		long num = x;
		for (int i = 0; i < n; i++) {
			answer[i] = num;
			num += x;
		}

		return answer;
	}

}
