package level1;

import java.util.*;

public class L1_kakao2019_실패율 {

	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		System.out.println(Arrays.toString(solution(N, stages)));
	}

	static class Node {
		Double fail;
		int idx;

		public Node(Double fail, int idx) {
			this.fail = fail;
			this.idx = idx;
		}
	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] stageCount = new int[501];

		for (int i = 0; i < stages.length; i++) {
			if (stages[i] == N + 1)
				continue;
			stageCount[stages[i]]++;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if (n1.fail < n2.fail)
					return 1;
				else if (n1.fail > n2.fail)
					return -1;
				else
					return n1.idx - n2.idx;
			}
		});
		int person = stages.length;
		for (int i = 1; i <= N; i++) {
			if (person <= 0) {
				pq.offer(new Node((double) 0, i));
			} else {
				pq.offer(new Node((double) stageCount[i] / person, i));
			}

			person -= stageCount[i];
		}

		int pqSize = pq.size();
		for (int i = 0; i < pqSize; i++) {
			answer[i] = pq.poll().idx;
		}

		return answer;

	}

}
