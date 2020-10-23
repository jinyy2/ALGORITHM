package codingTestHighScoreKit;

import java.util.HashMap;

public class Solution_해시_위장 {

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> hs = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			if (!hs.containsKey(clothes[i][1]))
				hs.put(clothes[i][1], 1);
			else {
				hs.put(clothes[i][1], hs.get(clothes[i][1]) + 1);
			}
		}

		for (String k : hs.keySet()) {
			answer *= hs.get(k) + 1;
		}
		answer -= 1;
		return answer;
	}

}
