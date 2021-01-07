package codingTestHighScoreKit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_스택큐_기능개발 {

	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(progresses,speeds)));
	}

	static class Point {
		int pro;
		int spd;

		public Point(int pro, int spd) {
			this.pro = pro;
			this.spd = spd;
		}
	}

	public static int[] solution(int[] progresses, int[] speeds) {

		ArrayList<Integer> list = new ArrayList<>();
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			queue.offer(new Point(progresses[i], speeds[i]));
		}
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				Point qTemp = queue.poll();
				qTemp.pro = qTemp.pro + qTemp.spd;
				if (qTemp.pro > 100)
					qTemp.pro = 100;
				queue.offer(qTemp);
			}

			int cnt = 0;
			while (!queue.isEmpty() && queue.peek().pro == 100) {
				queue.poll();
				cnt++;
			}
			if (cnt != 0)
				list.add(cnt);
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
