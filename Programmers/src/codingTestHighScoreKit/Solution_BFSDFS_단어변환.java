package codingTestHighScoreKit;

public class Solution_BFSDFS_단어변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hot";
		String target = "lot";
		String[] words = { "dot", "dog", "lot", "log" };
		System.out.println(solution(begin, target, words));
	}

	static int min = Integer.MAX_VALUE;
	static boolean[] visited;

	public static int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		int answer = 0;
		dfs(begin, target, words, 0);
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void dfs(String begin, String target, String[] words, int cnt) {

		if (begin.equals(target)) {
			if (min > cnt) {
				min = cnt;
			}
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (visited[i])
				continue; // 방문했으면 패스

			int differCount = 0;
			for (int j = 0; j < begin.length(); j++) { // 문자가 다른게 하나 있는지 체크
				if (begin.charAt(j) != words[i].charAt(j))
					differCount++;
			}
			if (differCount > 1)
				continue; // 2이상이면 패스

			visited[i] = true;
			dfs(words[i], target, words, cnt + 1);
			visited[i] = false;

		}

	}
}
