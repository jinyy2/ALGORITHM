package level2;

import java.util.*;

public class L2_kakao2019_튜플 {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(Arrays.toString(solution(s)));
	}

	static class Node {
		int value;
		int cnt;

		Node(int value, int cnt) {
			this.value = value;
			this.cnt = cnt;
		}
	}

	public static int[] solution(String s) {

		HashMap<Integer, Integer> map = new HashMap<>();
		String[] str = s.replaceAll("[{}]", "").split(",");
		for (int i = 0; i < str.length; i++) {
			int temp = Integer.parseInt(str[i]);
			map.put(temp, map.getOrDefault(temp, 0) + 1);
		}
		int[] answer = new int[map.size()];
		int index = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return -(n1.cnt - n2.cnt);
			}
		});
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			pq.offer(new Node(m.getKey(), m.getValue()));
		}
		for (int i = 0; i < answer.length; i++) {
			answer[i] = pq.poll().value;
		}

		return answer;
	}
}
