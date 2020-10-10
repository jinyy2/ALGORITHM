import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	static int N;
	static int[] T;
	static int[] P;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		T = new int[N+10];
		P = new int[N+10];
		max=0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		System.out.println(max);
	}

	private static void dfs(int t, int p) {
		if(t>=N){
			max = Math.max(max,p);
			return;
		}
		if(t+T[t]<=N) {
			dfs(t+T[t],p+P[t]);
		} 
			dfs(t+1,p);
		
	}

}
