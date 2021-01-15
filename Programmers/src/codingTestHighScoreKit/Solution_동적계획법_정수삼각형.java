package codingTestHighScoreKit;

public class Solution_동적계획법_정수삼각형 {

	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		System.out.println(solution(triangle));
	}

	public static int solution(int[][] triangle) {
		int answer = 0;
//	       내가 푼 방법
//	        int[][] map = new int[triangle.length][];
//	        for(int i=0;i<map.length;i++){
//	             map[i] = new int[i+1];
//	        }
//	        map[0][0] = triangle[0][0];        
//	        for(int i=0;i<triangle.length-1;i++){
//	            for(int j=0;j<triangle[i].length;j++){
//	              map[i+1][j]  = Math.max(map[i+1][j],map[i][j] + triangle[i+1][j]);
//	              map[i+1][j+1] = Math.max(map[i+1][j+1], map[i][j] + triangle[i+1][j+1]);
//	            }
//	        }
//	        
//	        int max = Integer.MIN_VALUE;
//	        for(int i=0;i<map.length;i++){
//	            max = Math.max(max,map[map.length-1][i]);
//	        }

		// 다른 사람 풀이 훨씬빠름
		for (int i = 1; i < triangle.length; i++) {
			triangle[i][0] += triangle[i - 1][0];
			triangle[i][i] += triangle[i - 1][i - 1];
			for (int j = 1; j < i; j++) {
				triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < triangle.length; i++) {
			max = Math.max(max, triangle[triangle.length - 1][i]);
		}
		answer = max;
		return answer;
	}
}
