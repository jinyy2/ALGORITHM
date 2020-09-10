public class Solution_이상한문자만들기 {

	public static void main(String[] args) {
		String s = "try hello world"; // 한 개 이상의 단어
	}

	public static String solution(String s) {
		String answer = "";
		boolean flag = true;
		for (int i = 0; i < s.length(); i++) {
			if (("" + s.charAt(i)).equals(" ")) {
				answer += " ";
				flag = true;
			} else if (flag) {
				answer += ("" + s.charAt(i)).toUpperCase();
				flag = false;
			} else if (!flag) {
				answer += ("" + s.charAt(i)).toLowerCase();
				flag = true;
			}
		}
		return answer;
	}
}
