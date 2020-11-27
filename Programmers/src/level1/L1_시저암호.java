package level1;

public class L1_시저암호 {
	class Solution {
		public String solution(String s, int n) {
			String answer = "";
			for (char c : s.toCharArray()) {
				int intC = (int) c;
				if (65 <= intC && intC < 91) {
					intC += n;
					if (intC >= 91) {
						intC -= 26;
					}
					answer += (char) intC;
				} else if (97 <= intC && intC < 123) {
					intC += n;
					if (intC >= 123) {
						intC -= 26;
					}
					answer += (char) intC;
				} else {
					answer += " ";
				}
			}
			return answer;

		}
	}
}
