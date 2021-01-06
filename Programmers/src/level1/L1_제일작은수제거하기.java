package level1;

import java.util.ArrayList;

public class L1_제일작은수제거하기 {
	class Solution {
		public int[] solution(int[] arr) {
			int[] answer;
			ArrayList<Integer> list = new ArrayList<Integer>();
			int idx = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				list.add(arr[i]);
				if (min > arr[i]) {
					min = arr[i];
					idx = i;
				}
			}
			list.remove(idx);
			if (list.size() > 1) {
				answer = new int[list.size()];
				for (int i = 0; i < list.size(); i++) {
					answer[i] = list.get(i);
				}
			} else {
				answer = new int[1];
				answer[0] = -1;
			}

			return answer;
		}
	}
}
