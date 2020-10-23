package codingTestHighScoreKit;

import java.util.Arrays;

public class Solution_해시_완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < participant.length; i++) {
			if (i == participant.length - 1)
				return participant[i];
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return answer;
	}

}
