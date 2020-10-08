import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {
	static long result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		result = 0;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		// input-end
		for (int i = 0; i < arr.length; i++) {
			// 총감독관
			if (arr[i] > 0) {
				arr[i] -= B;
				result++;
			}
			if (arr[i] <= 0)
				continue;

			// 부감독관
			result += arr[i] / C;
			if (arr[i] % C == 0)
				continue;
			else {
				result++;
			}

		}
		System.out.println(result);

	}

}
