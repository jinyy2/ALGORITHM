
import java.util.*;

public class L2_점프와순간이동 {

	public static void main(String[] args) {
		int n = 5000;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int ans = 1;

		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
				continue;
			} else if (n % 2 == 1) {
				n--;
				ans++;
			}
		}

		return ans;
	}

}
