import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기_DFS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
//		int[][] map = new int[N+1][N+1];

//		for(int i=0;i<N-1;i++) {
//			st = new StringTokenizer(br.readLine());
//			int r = Integer.parseInt(st.nextToken());
//			int c = Integer.parseInt(st.nextToken());

//			map[r][c] = 1;
//			map[c][r] = 1;

		ArrayList<Integer>[] list = new ArrayList[N + 1];
//		for (int i = 1; i <= N; i++) {
//			list[i] = new ArrayList<Integer>();
//		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if(list[r]==null) list[r] = new ArrayList<Integer>();
			if(list[c]==null) list[c] = new ArrayList<Integer>();
			
			list[r].add(c);
			list[c].add(r);
		}
		int[] parents = new int[N + 1];
		dfs(list, parents, 1, 0);

		for (int j = 2; j <= N; j++) {
			System.out.println(parents[j]);
		}

	}

	private static void dfs(ArrayList<Integer>[] list, int[] parents, int start, int parent) {
		parents[start] = parent;
		for (int i : list[start]) {
			if (i != parent)
				dfs(list, parents, i, start);

		}
	}

}
