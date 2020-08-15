package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_5656_벽돌깨기 {
	static int N, C, R;
	static int brickCnt; // 현재 맵에서 가지고 있는 벽돌의 개수
	static int answer;
	static int[][] mmap;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			mmap = new int[R][C];
			brickCnt = 0;

			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					mmap[r][c] = Integer.parseInt(st.nextToken());
					if (mmap[r][c] != 0) {
						brickCnt++;
					}
				}
			} // input-end
			answer = brickCnt;

			// 구슬을 하나씩 떨어뜨려보기
			dropBall(N, brickCnt, mmap);
//			print(map);

			System.out.println("#" + test_case + " " + answer);
		}

	}

	private static void dropBall(int r, int brickCnt, int[][] map) {
		if (r == 0) {
			answer = Math.min(answer, brickCnt);

			return;
		}
		for (int c = 0; c < C; c++) {
			// 1. 맵을 복제
			int[][] cloned = clone(map);
			// 2. 해당 컬럼의 처음 벽돌 가져오기
			Brick first = getFirstBrick(c, cloned);
			// 2-1. null: 벽돌이 없음 -> continue
			if (first == null)
				continue;
			// 3. 구슬을 떨어뜨려 벽돌을 깬다
			int broken = crashBrick(first, cloned);
			// 3-1. 이미 벽돌이 다 깨 -> 종료
			if (broken >= brickCnt) {
				answer = 0;
				return;
			}
			// 4. 화면 정리
			cleanMap(cloned);
			// 5. 다음 샷 발사
			dropBall(r - 1, brickCnt - broken, cloned);
		}
	}

	private static void cleanMap(int[][] map) {
		for (int c = 0; c < C; c++) {
			for (int r = R - 1, nr = R - 1; r >= 0; r--) {
				if (map[r][c] != 0) {
					int temp = map[r][c];
					map[r][c] = 0;
					map[nr--][c] = temp;
				}
			}
		}
	}

	private static int crashBrick(Brick first, int[][] map) {
		int broken = 0;
		// 충돌한 벽돌 삭제
		map[first.row][first.col] = 0;
		broken++;

		// 주변 벽돌 삭제
		for (int p = 1; p < first.pow; p++) {
			// 사방탐색
			for (int d = 0; d < 4; d++) {
				int nr = first.row + dr[d] * p;
				int nc = first.col + dc[d] * p;

				if (isIn(nr, nc) && map[nr][nc] != 0) {
					broken += crashBrick(new Brick(nr, nc, map[nr][nc]), map);

				}

			}

		}
		return broken;
	}

	private static boolean isIn(int r, int c) {

		return r < R && c < C && r >= 0 && c >= 0;
	}

	private static Brick getFirstBrick(int c, int[][] map) {
		for (int r = 0; r < R; r++) {
			if (map[r][c] != 0) {
				return new Brick(r, c, map[r][c]);
			}
		}
		return null;
	}

	private static int[][] clone(int[][] map) {
		int[][] temp = new int[R][C];
		for (int r = 0; r < R; r++) {
			temp[r] = map[r].clone(); // deep copy
		}

		return temp;
	}

	static class Brick {
		int row, col, pow;

		public Brick(int row, int col, int pow) {
			this.row = row;
			this.col = col;
			this.pow = pow;
		}

		@Override
		public String toString() {
			return "[" + row + ", " + col + ", " + pow + "]";
		}

	}

	// input-check
	private static void print(int[][] pr) {
		for (int[] p : pr) {
			System.out.println(Arrays.toString(p));
		}

	}

}
