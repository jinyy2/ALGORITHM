package level1;

public class L1_최대공약수와최소공배수 {

	public static void main(String[] args) {
		int n = 3;
		int m = 12;
		System.out.println(solution(n, n));
	}

	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
		int lcm = n * m;
		if (n > m) {
			int temp = n;
			n = m;
			m = temp;
		}
		int mod = 0;
		while (n != 0) {
			mod = m % n;
			m = n;
			n = mod;
		}
		answer[0] = m;
		answer[1] = lcm / answer[0];
		return answer;
	}

}
