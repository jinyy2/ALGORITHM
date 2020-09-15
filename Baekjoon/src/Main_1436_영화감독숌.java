import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436_영화감독숌 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = 665;
		
		while (cnt != N) {
			num++;
			char[] c = ("" + num).toCharArray();
			int cnt6 = 0;
			
			for (int i = 0; i < c.length; i++) {
				if (c[i] - '0' == 6) {
					cnt6++;
				} else {
					cnt6 = 0;
				}
				
				if (cnt6 == 3) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(num);
	}
}
