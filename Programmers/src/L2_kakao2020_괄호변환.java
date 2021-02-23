
import java.util.*;

public class L2_kakao2020_괄호변환 {

	public static void main(String[] args) {
		String p = "()))((()";
		System.out.println(solution(p));
	}

	static int strIdx;

	public static String solution(String p) {
		String answer = "";
		// 1.
		if (p.equals(""))
			return answer;
		// 2.
		boolean checkStr = corCh(p);

		String u = p.substring(0, strIdx + 1);
		String v = p.substring(strIdx + 1);
		if (checkStr)
			return u + solution(v);
		if (!checkStr)
			answer += "(" + solution(v) + ")";
		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(') {
				answer += ')';
			} else if (u.charAt(i) == ')') {
				answer += '(';
			}
		}
		return answer;
	}

	public static boolean corCh(String p) {
		Stack<Character> stack = new Stack<>();
		int leftCnt = 0;
		int rightCnt = 0;
		boolean flag = true;

		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);
			if (ch == '(') {
				leftCnt++;
				stack.push(ch);
			} else if (ch == ')') {
				rightCnt++;
				if (stack.isEmpty()) {
					flag = false;
				} else {
					stack.pop();
				}
			}
			if (leftCnt == rightCnt) {
				strIdx = i;
				return flag;
			}
		}
		return flag;

	}
}
