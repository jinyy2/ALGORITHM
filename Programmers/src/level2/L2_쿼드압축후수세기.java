package level2;

import java.util.Arrays;

public class L2_쿼드압축후수세기 {

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 0, 1, 0, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 } };
		System.out.println(Arrays.toString(solution(arr)));
	}

	static int[] answer;
	static int[][] map;

	public static int[] solution(int[][] arr) {
		answer = new int[2];
		map = arr;
		// 압축 가능 체크하기
		quad(0, 0, arr.length);
		return answer;
	}

	public static void quad(int r, int c, int k) {
		if (check(r, c, k)) {
			return;
		}
		// 분할
		quad(r, c, k / 2);
		quad(r + k / 2, c, k / 2);
		quad(r, c + k / 2, k / 2);
		quad(r + k / 2, c + k / 2, k / 2);

	}

	public static boolean check(int r, int c, int k) {
		int initNum = map[r][c];
		for (int i = r; i < r + k; i++) {
			for (int j = c; j < c + k; j++) {
				if (initNum != map[i][j])
					return false;
			}
		}
		if (initNum == 0)
			answer[0]++;
		else
			answer[1]++;
		return true;
	}

}
