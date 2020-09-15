import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231_분해합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 1; i < N; i++) {
			int number = i;
			int temp = i;

			char[] c = ("" + i).toCharArray();
			for (int j = 0; j < c.length; j++) {
				temp += c[j] - '0';
			}
			if (temp == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);

	}

}
