package level2;

import java.util.Arrays;

public class L2_삼각달팽이 {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(Arrays.toString(solution(n)));
	}

	static int[] dr = { 1, 0, -1 };
	static int[] dc = { 0, 1, -1 };

	public static int[] solution(int n) {
		int[][] arr = new int[n][]; // 배열 생성
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new int[i + 1]; // 배열의 크기 지정
		}
		int index = 0;
		int d = 0;
		int r = -1;
		int c = 0;
		for (int i = n; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				r = r + dr[d];
				c = c + dc[d];
				arr[r][c] = ++index;
			}
			d += 1;
			d = d % 3;
		}
		int[] answer = new int[index];
		index = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				answer[index++] = arr[i][j];
			}
		}

		return answer;
	}
}
