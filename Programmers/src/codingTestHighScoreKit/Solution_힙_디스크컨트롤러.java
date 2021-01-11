package codingTestHighScoreKit;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution_힙_디스크컨트롤러 {
	static class Job {
		int req;
		int runtime;

		public Job(int req, int runtime) {
			this.req = req;
			this.runtime = runtime;
		}
	}

	public static void main(String[] args) {
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		System.out.println(solution(jobs));
	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		LinkedList<Job> waiting = new LinkedList<>();
		PriorityQueue<Job> pq = new PriorityQueue<Job>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.runtime - o2.runtime;
			}
		});
		for (int[] job : jobs) {
			waiting.offer(new Job(job[0], job[1]));
		}
		Collections.sort(waiting, new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				return j1.req - j2.req;
			}
		});

		int cnt = 0;
		int time = waiting.peek().req;
		while (cnt < jobs.length) {
			while (!waiting.isEmpty() && waiting.peek().req <= time) {
				pq.offer(waiting.pollFirst());
			}

			if (!pq.isEmpty()) {
				Job j = pq.poll();
				time += j.runtime;
				answer += time - j.req;
				cnt++;
			} else {
				time++;
			}
		}

		return answer / cnt;
	}

}
