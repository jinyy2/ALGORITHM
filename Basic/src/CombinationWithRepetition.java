import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CombinationWithRepetition {
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
		totalCount = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Combi(0,0);
		System.out.println("총 개수: " + totalCount);
	}

	private static void Combi(int cnt,int cur) {
		if (cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = cur; i < N; i++) {
			number[cnt] = input[i];
			Combi(cnt + 1,i);
		}
	}
}
