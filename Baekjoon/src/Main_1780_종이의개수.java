import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {
	static int[][] map;
	static int[] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		answer = new int[3]; // -1,0,1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input-end
		paper(0, 0, N);

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void paper(int i, int j, int n) {
		if (check(i, j, n))
			return;

		for (int r = i; r < i + n; r += n / 3) {
			for (int c = j; c < j + n; c += n / 3) {
				paper(r, c, n / 3);
			}
		}
	}

	private static boolean check(int i, int j, int n) {
		int initValue = map[i][j];
		for (int r = i; r < i + n; r++) {
			for (int c = j; c < j + n; c++) {
				if (initValue != map[r][c])
					return false;
			}
		}
		answer[initValue + 1]++;
		return true;
	}

}
