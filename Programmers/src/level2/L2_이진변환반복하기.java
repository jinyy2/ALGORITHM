package level2;

import java.util.Arrays;

public class L2_이진변환반복하기 {

	public static void main(String[] args) {
		String s = "110010101001";
		System.out.println(Arrays.toString(solution(s)));
	}

	public static int[] solution(String s) {
		int[] answer = new int[2];

		while (!s.equals("1")) {
			int sLen = s.length();
			s = s.replaceAll("[0]", ""); // 1. 0제거
			answer[1] += sLen - s.length();
			int c = s.length();
			s = Integer.toString(c, 2);
			answer[0]++;
		}

		return answer;
	}
}
