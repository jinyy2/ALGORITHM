import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int N, M, R, C, K;
	static int[][] map;
	static int[] dr = { 0, 0, 0, -1, 1 }; // 동서북남
	static int[] dc = { 0, 1, -1, 0, 0 };
	static int[] dice = new int[7];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int k = Integer.parseInt(st.nextToken());
			rolling(k);
		}
	}

	private static void rolling(int k) {
		int[] temp = dice.clone();

		int nr = R + dr[k];
		int nc = C + dc[k];

		if (safe(nr, nc)) {
			if (k == 1) {
				dice[1] = temp[4];
				dice[3] = temp[1];
				dice[4] = temp[6];
				dice[6] = temp[3];
			} else if (k == 2) {
				dice[1] = temp[3];
				dice[3] = temp[6];
				dice[4] = temp[1];
				dice[6] = temp[4];
			} else if (k == 3) {
				dice[1] = temp[5];
				dice[2] = temp[1];
				dice[5] = temp[6];
				dice[6] = temp[2];
			} else {
				dice[1] = temp[2];
				dice[2] = temp[6];
				dice[5] = temp[1];
				dice[6] = temp[5];
			}

//			System.out.println("row: " + row.toString());
//			System.out.println("col: " + col.toString());
			if (map[nr][nc] == 0) {
				map[nr][nc] = dice[6];
			} else {
				dice[6] = map[nr][nc];
				map[nr][nc] = 0;
			}
			R = nr;
			C = nc;
			System.out.println(dice[1]);
		}

//		System.out.println("좌표확인: " + R + " " + C);
//		}	
	}

	private static boolean safe(int r, int c) {
		return 0 <= r && 0 <= c && r < N && c < M;
	}

}
