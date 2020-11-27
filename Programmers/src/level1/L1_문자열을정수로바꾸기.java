package level1;

public class L1_문자열을정수로바꾸기 {
	class Solution {
		public int solution(String s) {
			int answer = 0;
			if ("-".equals(s.substring(0, 1))) {
				answer = -Integer.parseInt(s.substring(1));
			} else {
				answer = Integer.parseInt(s);
			}
			return answer;
		}
	}
}
