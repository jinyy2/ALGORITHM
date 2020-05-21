package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_9317_석찬이의받아쓰기 {
	static int T, N;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String str2 = br.readLine();
			count = 0;

			for (int i = 0; i < N; i++) {
				if (str.charAt(i) == str2.charAt(i)) {
					count++;
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}