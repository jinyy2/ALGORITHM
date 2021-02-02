package level2;

public class L2_kakao2018_n진수게임 {

	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		System.out.println(solution(n, t, m, p));
		System.out.println(solution2(n, t, m, p));
	}

	//내 코드
	public static String solution(int n, int t, int m, int p) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		sb.append(0);

		for (int i = 0; i < t * m; i++) {

			String num = "";
			int value = i;
			// value -> n진수로 변환
			while (value != 0) {
				if (n >= 11) {
					if (value % n >= 10 && value % n < n) {

						num = (char) (value % n + 55) + num;

					} else
						num = value % n + num;

				} else {
					num = value % n + num;
				}
				value /= n;
			} // while-end
			sb.append(num);
		} // for-end

		int cnt = 0;
		int idx = p - 1;
		String[] str = sb.toString().split("");

		while (cnt < t) {

			answer += str[idx];
			idx += m;
			cnt++;
		}
		return answer;
	}

	//다른사람코드 이게 더 빠름
	public static String solution2(int n, int t, int m, int p) {
		String answer = "";
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t * m; i++) {
			sb.append(Integer.toString(i, n));
		} // for-end
		int cnt = 0;
		int idx = p - 1;
		String[] str = sb.toString().split("");

		while (cnt < t) {

			answer += str[idx];
			idx += m;
			cnt++;
		}
		return answer.toUpperCase();
	}

}
