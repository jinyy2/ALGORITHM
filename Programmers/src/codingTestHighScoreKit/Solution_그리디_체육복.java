package codingTestHighScoreKit;

import java.util.*;

public class Solution_그리디_체육복 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 1, 2 };
		int[] reserve = { 2, 3 };
		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] stu = new int[n];
		boolean[] visited = new boolean[n];

		Arrays.fill(stu, 1);
		for (int i = 0; i < lost.length; i++) {
			stu[lost[i] - 1]--;
		}
		for (int i = 0; i < reserve.length; i++) {
			visited[reserve[i] - 1] = true;
		}
		for (int i = 0; i < stu.length; i++) {
			if (stu[i] == 0) {
				if (visited[i]) {
					stu[i] = 1;
					visited[i] = false;
				} else if (i > 0 && stu[i - 1] == 1 && visited[i - 1]) {
					visited[i - 1] = false;
					stu[i] = 1;
				} else if (i < stu.length - 1 && stu[i + 1] == 1 && visited[i + 1]) {
					visited[i + 1] = false;
					stu[i] = 1;
				}
			}
		}

		for (int i : stu) {
			if (i > 0)
				answer++;
		}
		return answer;
	}
}
