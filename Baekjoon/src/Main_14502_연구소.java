import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {

	static int[][] map;
	static ArrayList<Wall> list;
	static ArrayList<Virus> vlist;
	static boolean[] visited;
	static Wall[] num;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int result;
	static int N, M;

	static class Virus {
		int r;
		int c;

		public Virus(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Wall {
		int r;
		int c;

		public Wall(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		vlist = new ArrayList<>();
		num = new Wall[3];
		result = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 0) {
					list.add(new Wall(i, j));
				}
				if (map[i][j] == 2) {
					vlist.add(new Virus(i, j));
				}
			}
		} // input-end
//		print(map);
		visited = new boolean[list.size()];

		combi(0, 0); // 조합을 사용하여 벽 세개의 모든 경우의 수의 좌표를 찾음
//		print(map);
		System.out.println(result);
	}

	private static void combi(int cnt, int cur) {
		// 벽 좌표가 세 개일 때
		if (cnt == 3) {

			int[][] cMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				cMap[i] = map[i].clone();
			}

			// 벽세우기
			for (int i = 0; i < num.length; i++) {
				int r = num[i].r;
				int c = num[i].c;
				cMap[r][c] = 1;
			}

			// 바이러스 퍼짐
			Queue<Virus> vq = new LinkedList<>();
			for (int i = 0; i < vlist.size(); i++) {
				int r = vlist.get(i).r;
				int c = vlist.get(i).c;
				vq.offer(new Virus(r, c));
			}
			while (!vq.isEmpty()) {
				Virus v = vq.poll();

				for (int d = 0; d < 4; d++) {
					int nr = v.r + dr[d];
					int nc = v.c + dc[d];
					if (!safe(nr, nc))
						continue;

					if (safe(nr, nc) && cMap[nr][nc] == 0) {
						cMap[nr][nc] = 2;
						vq.offer(new Virus(nr, nc));
					}
				}
			}
			// 바이러스가 퍼진 후 안전지대의 넓이 확인
			result = Math.max(result, countZero(cMap)); // 안전지대의 넓이가 비교
			return;
		}

		for (int i = cur; i < list.size(); i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			num[cnt] = list.get(i);
			combi(cnt + 1, i + 1);
			visited[i] = false;
		}
	}

	// 0의 개수 세기
	private static int countZero(int[][] copyMap) {
		int cnt = 0;
		for (int i = 0; i < copyMap.length; i++) {
			for (int j = 0; j < copyMap[i].length; j++) {
				if (copyMap[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	// 배열의 범위
	private static boolean safe(int nr, int nc) {
		return 0 <= nr && 0 <= nc && nr < N && nc < M;
	}

	private static void print(int[][] pr) {
		for (int[] p : pr) {
			System.out.println(Arrays.toString(p));
		}
	}
}
