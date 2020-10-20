package codingTestHighScoreKit;

import java.util.Arrays;

public class Solution_정렬_K번째수 {

	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		System.out.println(Arrays.toString(solution(array, commands)));
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int[] temp = new int[commands[i][1] - commands[i][0] + 1];
			int t = commands[i][0] - 1;
			for (int j = 0; j < temp.length; j++) {
				temp[j] = array[t++];
			}
			Arrays.sort(temp);
			answer[i] = temp[commands[i][2] - 1];
		}
		return answer;
	}
}
