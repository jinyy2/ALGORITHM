package codingTestHighScoreKit;

import java.util.Arrays;

public class Solution_정렬_H_Index {
	

	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {
		
		int answer = 0;
		
		for (int h = citations.length; h > 0; h--) {
			int up = 0;
			for (int j = 0; j < citations.length; j++) {
				if(h<=citations[j])up++;
				
			}
			if(up>=h&&citations.length-up<=h) return h;
		}

		return answer;
	}

}
