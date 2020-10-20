package codingTestHighScoreKit;
import java.util.Arrays;

public class Solution_완전탐색_카펫 {

	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		System.out.println(Arrays.toString(solution(brown, yellow)));

	}

	public static int[] solution(int brown, int yellow) {
		int mul = brown + yellow;
		int width = 0;
		int height = 0;
		for (int i = 1; i <= mul; i++) {
			if (mul % i != 0)
				continue;
			if (mul / i < i)
				break;
			height = i;
			width = mul / i;
			if (2 * (width + height) - 4 == brown)
				break;
		}
		int[] answer = { width, height };
		return answer;
	}

}
