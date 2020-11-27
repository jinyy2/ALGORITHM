package level1;

public class L1_비밀지도 {
	class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];

			for (int i = 0; i < n; i++) {
				String bs = Integer.toBinaryString(arr1[i] | arr2[i]);

				while (bs.length() < n) {
					bs = "0" + bs;
				}
				bs = bs.replaceAll("0", " ");
				bs = bs.replaceAll("1", "#");
				answer[i] = bs;
			}

			return answer;
		}
	}
}
