package codingTestHighScoreKit;

public class Solution_그리디_조이스틱 {

	public static void main(String[] args) {
		String name = "JEROEN";
		System.out.println(solution(name));
	}

	public static int solution(String name) {
		int answer = 0;
		int minMove = name.length() - 1;
		for (int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

			int idx = i + 1;
			while (idx < name.length() && name.charAt(idx) == 'A') {
				idx++;
			}
			minMove = Math.min(minMove, i + name.length() - idx + i);
		}

		return answer + minMove;
	}
}
