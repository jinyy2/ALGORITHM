package level2;

public class L2_행렬의곱셈 {

	public static void main(String[] args) {
		int[][] arr1 = { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } };
		int[][] arr2 = { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } };
		System.out.println(solution(arr1, arr2));
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		// m*n n*o = m*o
		int[][] answer = new int[arr1.length][arr2[0].length];
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				for (int k = 0; k < arr1[0].length; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];

				}

			}
		}
		return answer;
	}
}
