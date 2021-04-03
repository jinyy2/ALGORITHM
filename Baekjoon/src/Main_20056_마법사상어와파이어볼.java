import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_20056_마법사상어와파이어볼 {

	static int N, M, K;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static LinkedList<FireBall>[][] map;

	static class FireBall {
		int m;
		int s;
		int d;

		public FireBall(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}

		
		@Override
		public String toString() {
			return "FireBall [m=" + m + ", s=" + s + ", d=" + d + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new LinkedList[N][N]; // N*N 격자
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r - 1][c - 1].add(new FireBall(m, s, d));
		}
		// input-end

		for (int k = 0; k < K; k++) {
			// 이동
			LinkedList<FireBall>[][] next = new LinkedList[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					next[i][j] = new LinkedList<>();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (map[i][j].size() != 0) {
						for (FireBall fb : map[i][j]) {
							int nr = i + dr[fb.d] * fb.s % N;
							int nc = j + dc[fb.d] * fb.s % N;
							if (nr < 0)
								nr += N;
							else if (nr >= N)
								nr -= N;
							if (nc < 0)
								nc += N;
							else if (nc >= N)
								nc -= N;
							next[nr][nc].add(new FireBall(fb.m, fb.s, fb.d));
						}
					}
				}
			}
			map = next;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].size() >= 2) {
						boolean even = false, odd = false;
						int mSum = 0, sSum = 0;
						for (FireBall fb : map[i][j]) {

							if (fb.d % 2 == 0)
								even = true;
							else
								odd = true;
							mSum += fb.m;
							sSum += fb.s;

						}
						mSum /= 5;
						sSum /= map[i][j].size();
						map[i][j].clear();

						if (mSum == 0)
							continue;
						for (int z = 0; z < 8; z += 2) {
							if (!odd || !even) {
								map[i][j].add(new FireBall(mSum, sSum, z));
							} else {
								map[i][j].add(new FireBall(mSum, sSum, 1 + z));
							}
						}
					}
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (FireBall fb : map[i][j]) {
					sum += fb.m;
				}
			}
		}
		System.out.println(sum);

	}

}
