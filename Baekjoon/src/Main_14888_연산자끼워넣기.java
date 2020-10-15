import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {

	static int N;
	static int[] num;
	static char[] op;
	static char[] operator = { '+', '-', '*', '/' };
	static boolean[] visited;
	static char[] permuOp;
	static int max;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		op = new char[N - 1];
		visited = new boolean[N - 1];
		permuOp = new char[N - 1];
		int temp = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) { // 0,1,2,3
			int opCnt = Integer.parseInt(st.nextToken()); // 2,3,3,3

			for (int j = 0; j < opCnt; j++) {
				op[temp++] = operator[i];
			}
		} // input-end
//		System.out.println(Arrays.toString(op));
		permu(0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void permu(int cnt) {
		if (cnt == N - 1) {
			int val = num[0];
			for (int i = 0; i < N - 1; i++) {
				val = cal(val, permuOp[i], num[i + 1]);
				if (val > 1000000000 && val < -1000000000)
					return;

			}
			max = Math.max(max, val);
			min = Math.min(min, val);
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			permuOp[cnt] = op[i];
			permu(cnt + 1);
			visited[i] = false;
		}
	}

	private static int cal(int val, char c, int k) {
		if (c == '+')
			return val + k;
		else if (c == '-')
			return val - k;
		else if (c == '*')
			return val * k;
		else if (c == '/') {
			if (val < 0) {
				return ((int) (Math.abs(val) / k) * -1);
			} else
				return (int) (val / k);

		}
		return 0;

	}

}
