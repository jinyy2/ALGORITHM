package level1;

public class L1_문자열다루기기본 {
	class Solution {
		public boolean solution(String s) {
			boolean answer = true;
			if (!(s.length() == 4 || s.length() == 6))
				return false;

			for (int i = 0; i < s.length(); i++) {
				System.out.println(i + " " + s.charAt(i));
				if (0 > s.charAt(i) - '0' || s.charAt(i) - '0' > 9)
					return false;
			}
			return answer;
		}
	}
}
