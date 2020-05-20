package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_4299_태혁이의사랑은타이밍 {
	static int D, H, M;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if ((D == 11 && H < 11) || (D == 11 && H == 11 && M < 11)) {
				result = -1;
			} else {
				int newD = D - 11;
				int newH = H - 11;
				int newM = M - 11;
				result = newD * 1440 + newH * 60 + newM;
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}
