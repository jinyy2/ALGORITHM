package level2;

import java.util.*;

public class L2_올바른괄호 {

	public static void main(String[] args) {
		String s = "(())()";
		System.out.println(solution(s));
	}

	static boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (stack.isEmpty()) {
				if (s.charAt(i) == ')') {
					answer = false;
					break;
				}
				stack.push(ch);
			} else {
				char sp = stack.peek();
				if (sp == '(' && ch == '(') {
					stack.push(ch);
				} else if (sp == '(' && ch == ')') {
					stack.pop();
				} else if (sp == ')') {
					answer = false;
					break;
				}
			}
		}
		if (!stack.isEmpty())
			answer = false;
		return answer;
	}
}
