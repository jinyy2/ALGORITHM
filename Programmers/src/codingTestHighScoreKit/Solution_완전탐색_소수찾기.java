package codingTestHighScoreKit;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_완전탐색_소수찾기 {
	static char[] c, ch;
	static boolean[] visited;
	static int count;
	static HashSet<Integer> hs;

	public static void main(String[] args) {
		String input = "1231";
		System.out.println(solution(input));
	}

	public static int solution(String numbers) {
		ch = numbers.toCharArray();
		visited = new boolean[ch.length];
		count = 0;
		hs = new HashSet<Integer>();
		for (int i = 1; i <= ch.length; i++) {
			c = new char[i];
			permutation(ch.length, i, 0);
		}

		for (int number : hs) {
			boolean isPrime = true;

			for (int i = 2; i <= (int) Math.sqrt(number); i++) {
				if (number % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime && number > 1) {
				count++;
			}

		}

		int answer = count;
		return answer;
	}

	private static void permutation(int n, int r, int cnt) {
		if (cnt == r) {
			String str = "";
			boolean flagZero = true;
			for (int i = 0; i < c.length; i++) {
				if (flagZero && i != 0) {
					flagZero = false;
				}
				str += c[i];
			}
			hs.add(Integer.parseInt(str));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			c[cnt] = ch[i];
			permutation(n, r, cnt + 1);
			visited[i] = false;
		}
	}

}
