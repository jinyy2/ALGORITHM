package level2;

public class L2_kakao2020_문자열압축 {

	public static void main(String[] args) {
		String[] input = { "aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede",
				"xababcdcdababcdcd" };
		for (int i = 0; i < input.length; i++) {
			System.out.println(solution(input[i]));
		}
	}

	public static int solution(String s) {
		int answer = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= s.length() / 2 + 1; i++) {
			String str = "";
			int j = 0;
			while (j < s.length()) {
				String tempStr = "";
				if (j < s.length() - i) {
					tempStr = s.substring(j, j + i);
				} else {
					tempStr = s.substring(j);
				}
				j += i;
				int count = 1;

				while (j <= s.length() - i && tempStr.equals(s.substring(j, j + i))) {
					j += i;
					count++;

				}
				if (count > 1) {
					str += Integer.toString(count) + "" + tempStr;
				} else {
					str += tempStr;
				}

			}
			min = Math.min(min, str.length());
		}
		answer = min;
		return answer;
	}

}
