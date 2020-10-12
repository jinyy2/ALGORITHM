import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
	static int N, L;
	static int[][] map;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		for (int i = 0; i < N; i++) {
			if (go(i, 0, 0))
				result++;
			if (go(0, i, 1))
				result++;
		}

//		print(map);
		System.out.println(result);

	}

	private static boolean go(int r, int c, int dir) {
		boolean[] visited = new boolean[N];
		int[] height = new int[N];
		for (int i = 0; i < N; i++) {
			height[i] = (dir == 0) ? map[r][c + i] : map[r + i][c];
		}
		for (int i = 0; i < height.length - 1; i++) {
			// 높이가 같으면
			if (height[i] == height[i + 1])
				continue;

			// 높이 차이가 2 이상이면
			if (Math.abs(height[i] - height[i + 1]) > 1)
				return false;

			// 올라가는 경사로
			if (height[i] == height[i + 1] - 1) {
				for (int j = i; j > i - L; j--) {
					if (j < 0 || visited[j] || (height[j] != height[i]))
						return false;
					visited[j] = true;
				}
			}

			// 내려가는 경사로
			else if (height[i] == height[i + 1] + 1) {
				for (int j = i + 1; j <= i + L; j++) {
					if (j >= N || visited[j] || (height[j] != height[i + 1]))
						return false;
					visited[j] = true;
				}
			}
		}

		return true;
	}

	private static void print(int[][] pr) {
		for (int[] p : pr) {
			System.out.println(Arrays.toString(p));
		}
	}

}
