import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permutation {
	static int N, R;
	static boolean[] visited;
	static int[] number, input;
	static int totalCount;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		number = new int[R];
		input = new int[N];
		visited = new boolean[N];
		totalCount = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Permutation(0);
		System.out.println("총 개수: " + totalCount);
	}

	private static void Permutation(int cnt) {
		if (cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			number[cnt] = input[i];
			Permutation(cnt + 1);
			visited[i] = false;
		}
	}
}
