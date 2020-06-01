	package D3;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class Solution_D3_6190_정곤이의단조증가하는수 {
		static int N;
		static int[] num;
		static int max;
	
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			int T = Integer.parseInt(br.readLine());
	
			for (int test_case = 1; test_case <= T; test_case++) {
				N = Integer.parseInt(br.readLine());
				num = new int[N];
				max = -1;
				st = new StringTokenizer(br.readLine());
	
				for (int i = 0; i < N; i++) {
					num[i] = Integer.parseInt(st.nextToken());
				}
				for (int i = 0; i < N - 1; i++) {
					for (int j = i+1; j < N-1; j++) {
						int AixAj = num[i] * num[j];
						if (check("" + AixAj)) {
							if (max < AixAj) {
								max = AixAj;
							}
						}
					}
				}
	
				System.out.println("#" + test_case + " " + max);
			}
		}
	
		private static boolean check(String a) {
			
			for (int i = 0; i < a.length() - 1; i++) {
				if (a.charAt(i) > a.charAt(i + 1)) {
					return false;
				}
			}
			return true;
	
		}
	
	}
