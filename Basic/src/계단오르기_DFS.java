import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_DFS {

	static int N;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = 0;
		dfs(0);
		System.out.println(result);
	}

	private static void dfs(int s) {
		if (s > N) {
			return;
		}

		if (s == N) {
			result++;
			return;
		}
		dfs(s + 1);
		dfs(s + 2);
	}
}
