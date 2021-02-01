package level2;

import java.util.*;

public class L2_JadenCase문자열만들기 {

	public static void main(String[] args) {
		String s = "3people unFollowed me";
		System.out.println(solution1(s)); // 내 코드
		System.out.println(solution2(s)); // 다른사람코드 더 빠름

	}

	public static String solution1(String s) {
		String answer = "";
		char[] ch = s.toLowerCase().toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				flag = false;
			} else if (0 <= ch[i] && ch[i] <= 9)
				flag = true;
			else if (!flag && ch[i] != ' ') {
				flag = true;

				sb.append(("" + ch[i]).toUpperCase());
				continue;
			}
			sb.append(ch[i]);
		}
		answer = sb.toString();
		return answer;
	}

	public static String solution2(String s) {
		String answer = "";
		String[] sp = s.toLowerCase().split("");
		boolean flag = true;

		for (String ss : sp) {
			answer += flag ? ss.toUpperCase() : ss;
			flag = ss.equals(" ") ? true : false;
		}

		return answer;

	}
}
