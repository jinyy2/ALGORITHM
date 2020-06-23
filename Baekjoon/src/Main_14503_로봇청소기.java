import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {

	static int N, M, r, c, d;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		cnt = 0;

		// 첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// 둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을,
		// 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		// 셋째 줄부터 N개의 줄에 장소의 상태가 북쪽부터 남쪽 순서대로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 빈 칸은 0, 벽은 1로
		// 주어진다. 지도의 첫 행, 마지막 행, 첫 열, 마지막 열에 있는 모든 칸은 벽이다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input-end
		go(r, c, d);
		System.out.println(cnt);

	}

	private static void go(int r, int c, int d) {

//		현재 위치를 청소한다.
		if (map[r][c] == 0) {
			map[r][c] = 2;
			cnt++;
		}

		int rotateCnt = 0;
		for (int i = 0; i < 4; i++) {
			int newR = r + dr[i];
			int newC = c + dc[i];
			if (map[newR][newC] == 2 || map[newR][newC] == 1) {
				rotateCnt++;
			}
		}
		if (rotateCnt == 4) {// d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
			if (map[r + dr[(d + 2) % 4]][c + dc[(d + 2) % 4]] == 1)
				return;
			else // c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
				go(r + dr[(d + 2) % 4], c + dc[(d + 2) % 4], d);

		} else {

//		2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다. 		
			if (d == 0) // 북
				d = 3; // 서
			else if (d == 3) // 서
				d = 2; // 남
			else if (d == 2)// 남
				d = 1; // 동
			else if (d == 1) // 동
				d = 0;// 북

			int nr = r + dr[d];
			int nc = c + dc[d];

			if (map[nr][nc] == 0) {// a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
				go(nr, nc, d);
			} else {// b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
				go(r, c, d);
			}
		}
	}

	private static void print(int[][] pr) {
		for (int i = 0; i < pr.length; i++) {
			for (int j = 0; j < pr[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
