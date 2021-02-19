package level2;

public class L2_N개의최소공배수 {

	public static void main(String[] args) {
		int[] arr = { 2, 6, 8, 14 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {
		int answer = 0;
		int lcm = arr[0];
		for (int i = 1; i < arr.length; i++) {
			lcm = lcm * arr[i] / getLcm(lcm, arr[i]);
		}
		answer = lcm;
		return answer;
	}

	public static int getLcm(int a, int b) {
		int temp;
		while (b != 0) {
			temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
