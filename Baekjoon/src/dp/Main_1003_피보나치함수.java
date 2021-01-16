package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치함수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] fibo = new int[41];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i < fibo.length; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				System.out.println(1 + " " + 0);
			else
				System.out.println(fibo[n - 1] + " " + fibo[n]);
		}

	}

}
