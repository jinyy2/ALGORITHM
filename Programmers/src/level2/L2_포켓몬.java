package level2;

import java.util.*;

public class L2_포켓몬 {

	public static void main(String[] args) {
		int[] nums = { 3, 3, 3, 2, 2, 4 };
		System.out.println(solution(nums));
	}

	static class Number {
		int num;
		int count;

		Number(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}

	public static int solution(int[] nums) {
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		PriorityQueue<Number> pq = new PriorityQueue<>(new Comparator<Number>() {
			@Override
			public int compare(Number n1, Number n2) {
				return n1.count - n2.count;
			}
		});
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			pq.offer(new Number(m.getKey(), m.getValue()));
		}
		Queue<Number> queue = new LinkedList<>();
		while (!pq.isEmpty()) {
			queue.offer(pq.poll());
		}
		boolean[] visited = new boolean[200001];

		for (int i = 0; i < nums.length / 2; i++) {
			Number n = queue.poll();
			if (visited[n.num]) {
				queue.offer(n);
				continue;
			}
			visited[n.num] = true;
			answer++;
			if (n.count - 1 > 0) {
				queue.offer(new Number(n.num, n.count - 1));
			}
		}
		return answer;
		
	
		/* 다른 사람 코드
		 int answer = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        if(hs.size()>=nums.length/2)return nums.length/2;
        return hs.size();
		 */
		 
	}

}
