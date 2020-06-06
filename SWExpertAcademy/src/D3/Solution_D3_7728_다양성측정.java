package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_7728_다양성측정{
	static char[] arr;
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			arr = br.readLine().toCharArray();
			check = new boolean[10];
			int count = 0;
			
			for (int i = 0; i < arr.length; i++) {
					check[arr[i]-'0'] = true;
			}
			for (int i = 0; i < check.length; i++) {
				if(check[i]) {
					count++;
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
	}
}