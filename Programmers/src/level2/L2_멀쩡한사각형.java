package level2;

public class L2_멀쩡한사각형 {

	public static void main(String[] args) {
		int w = 12;
		int h = 8;
		System.out.println(solution(w, h));
	}

	public static long solution(int w, int h) {
		long answer = 1;
		long gcdValue = gcd(w, h);
		answer = (long) w * h - (w / gcdValue + h / gcdValue - 1) * gcdValue;
		return answer;

	}

	public static long gcd(int w, int h) {
		while (h != 0) {
			int temp = w % h;
			w = h;
			h = temp;
		}
		return w;

	}
}
