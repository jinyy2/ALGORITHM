import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
각기 다른 열과 행의 
3
1 5 3 
2 4 7 
5 3 5
 * */
public class MinimumSum_DFS {
	
	static int N;
	static int[][] map;
	static boolean[] vcol;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		vcol = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		} //input-end
		min = Integer.MAX_VALUE;
		dfs(0,0);
		System.out.println(min);
	}
	private static void dfs(int r, int sum) {
		if(r==N) {
			min = Math.min(min, sum);
			return;
		}
		for (int c = 0; c < N; c++) {
			if(!vcol[c]) {
				vcol[c] = true;
				dfs(r+1,sum+map[r][c]);
				vcol[c] = false;
			}
		}
	}

}
