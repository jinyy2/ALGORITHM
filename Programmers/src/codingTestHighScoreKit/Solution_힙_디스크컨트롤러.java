package codingTestHighScoreKit;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution_힙_디스크컨트롤러 {
	static class Job {
		int req;
		int run;

		public Job(int req, int run) {
			this.req = req;
			this.run = run;
		}
	}

	public static void main(String[] args) {
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		System.out.println(solution(jobs));

	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		LinkedList<Job> waiting = new LinkedList<>();
		for (int[] job : jobs) {
			waiting.offer(new Job(job[0], job[1]));
		}
		Collections.sort(waiting, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.req - o2.req;
			}
		});

		PriorityQueue<Job> pq = new PriorityQueue<Job>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.run - o2.run;
			}
		});

		int cnt = 0;
		int time = 0;
		while (cnt < jobs.length) {
			while (!waiting.isEmpty() && waiting.peek().req <= time) {
				pq.offer(waiting.poll());
			}
			if (!pq.isEmpty()) {
				Job job = pq.poll();
				time += job.run;
				answer += time - job.req;
				cnt++;
			} else {
				time++;
			}
		}

		return answer / cnt;
	}
}
