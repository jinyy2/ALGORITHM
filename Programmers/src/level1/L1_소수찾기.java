package level1;

public class L1_소수찾기 {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 1;
		boolean[] visited = new boolean[n + 1];

		for (int i = 3; i <= n; i += 2) {
			if (visited[i])
				continue;
			boolean flag = true;
			for (int j = 2; j < (int) Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				answer++;
				for (int j = i; j <= n; j += i) {
					visited[j] = true;
				}
			}
		}
		return answer;
	}

}
