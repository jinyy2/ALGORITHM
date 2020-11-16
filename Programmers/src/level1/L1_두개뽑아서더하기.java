package level1;

import java.util.*;

public class L1_두개뽑아서더하기 {

	class Solution {
		public int[] solution(int[] numbers) {

			TreeSet<Integer> ts = new TreeSet<>();
			for (int i = 0; i < numbers.length - 1; i++) {
				for (int j = i + 1; j < numbers.length; j++) {
					ts.add(numbers[i] + numbers[j]);
				}
			}
			int[] answer = new int[ts.size()];
			for (int i = 0; i < answer.length; i++) {
				answer[i] = ts.pollFirst();
			}
			return answer;

		}
	}

}
