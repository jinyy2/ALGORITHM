package level2;

import java.util.Arrays;
import java.util.Stack;

public class L2_kakao2018_영어끝말잇기 {

	public static void main(String[] args) {
		int n = 2;
		String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };
		System.out.println(Arrays.toString(solution(n, words)));
	}

	public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		Stack<String> stack = new Stack<>();
		stack.push(words[0]);
		answer[1] = 1;
		for (int i = 1; i < words.length; i++) {
			if (stack.contains(words[i])) {
				answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
				return answer;
			} else {

				String exStr = stack.peek();
				if (exStr.charAt(exStr.length() - 1) != words[i].charAt(0)) {
					answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
					return answer;
				} else {
					stack.push(words[i]);
					if ((i + 1) % n == 0) {
						answer[1]++;
					}
				}

			}
		}

		answer[0] = 0;
		answer[1] = 0;
		return answer;
	}

}
