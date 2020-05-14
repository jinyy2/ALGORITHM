package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1961_숫자배열회전 {
	static int T;
	static int N;
	static String arr[][];
	static String arr90[][];
	static String arr180[][];
	static String arr270[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(bf.readLine());
			arr = new String[N][N];
			for (int j = 0; j < N; j++) {
				String str = bf.readLine();
				arr[j] = str.split(" ");
			}
			arr90 = new String[N][N];
			arr180 = new String[N][N];
			arr270 = new String[N][N];
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					arr90[y][x] = arr[(N-1) - x][y];
				}
			}
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					arr180[y][x] = arr90[(N-1) - x][y];
				}
			}
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					arr270[y][x] = arr180[(N-1) - x][y];
				}
			}
			
			//출력
			System.out.println("#"+(i+1));
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr90[k][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr180[k][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr270[k][j]);
				}
				System.out.println();
			}
		}
		
	}
}
