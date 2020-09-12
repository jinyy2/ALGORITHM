package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3752_가능한시험점수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			int[] num = new int[N];
			int answer = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				sum += num[i];
			} // input-end

			boolean[] visited = new boolean[sum + 1]; // sum값을 포함하기 위해 +1
			visited[0] = true; // 모든 문제를 틀릴 경우
			for (int i = 0; i < N; i++) {
				for (int j = sum; j >= 0; j--) {
					if (visited[j])
						visited[num[i] + j] = true;
				}
			}
			for (int i = 0; i < visited.length; i++) {
				if (visited[i])
					answer++;
			}

			System.out.println("#" + test_case + " " + answer);
		}
	}
}


