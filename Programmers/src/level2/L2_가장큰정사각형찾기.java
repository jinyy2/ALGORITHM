package level2;

public class L2_가장큰정사각형찾기 {

	public static void main(String[] args) {	
		int[][] board ={{0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {0,0,1,0}};
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
			int answer = Integer.MIN_VALUE;
			int[][] map = new int[board.length + 1][board[0].length + 1];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					map[i + 1][j + 1] = board[i][j];
				}
			}
			for (int i = 1; i < map.length; i++) {
				for (int j = 1; j < map[i].length; j++) {
					if (map[i][j] == 0)
						continue;
					map[i][j] = Math.min(map[i - 1][j], Math.min(map[i][j - 1], map[i - 1][j - 1])) + 1;
					answer = Math.max(answer, map[i][j]);
				}
			}

			return answer * answer;
		}
}
