package codingTestHighScoreKit;

import java.util.PriorityQueue;

public class Solution_힙_더맵게 {

	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3 };
		int K = 11;
		System.out.println(solution(scoville, K));
	}

	public static int solution(int[] scoville, int K) {

		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int value : scoville) {
			pq.offer(value);
		}
		while (pq.peek() < K && pq.size() > 1) {

			int first = pq.poll();
			int second = pq.poll();
			int mixed = first + second * 2;
			pq.offer(mixed);
			answer++;

		}
		if (pq.peek() < K && pq.size() == 1)
			answer = -1;

		return answer;

	}

}
