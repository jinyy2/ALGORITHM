package level2;

import java.util.Stack;

public class L2_짝지어제거하기 {

	public static void main(String[] args) {
		String s = "abccba";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (!stack.isEmpty()) {
				if (stack.peek() == ch[i]) {
					stack.pop();
				} else {
					stack.add(ch[i]);
				}
			} else {
				stack.add(ch[i]);
			}
		}
		if (stack.isEmpty())
			return 1;
		return 0;

	}

}
