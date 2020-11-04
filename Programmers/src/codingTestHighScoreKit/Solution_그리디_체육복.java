package codingTestHighScoreKit;

public class Solution_그리디_체육복 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 1, 2 };
		int[] reserve = { 2,3 };
		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		boolean[] visited = new boolean[n + 1];
		for (int i = 0; i < lost.length; i++) {
			visited[lost[i]] = true; // 체육복이 없는 사람
		}
		boolean[] reserveVisited = new boolean[visited.length];
		for (int i = 0; i < reserve.length; i++) {
			reserveVisited[reserve[i]] = true; // 체육복을 빌려줄 수 있는 사람
		}
		int[] di = { -1, 1 };
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) { // 체육복이 없어
				for (int d = 0; d < 2; d++) {
					int ni = i + di[d];
					if (!(1 <= ni && ni < visited.length))
						continue;
					if (reserveVisited[ni]) // 체육복이 있어
					{
						reserveVisited[ni] = false;
						visited[i] = false;
					}
				}
			}
		}
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i])
				answer++;
		}
		return answer;
	}

}
